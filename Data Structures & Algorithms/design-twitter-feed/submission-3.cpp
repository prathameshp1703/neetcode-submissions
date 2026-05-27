class Twitter {
public:
    map<int, set<int>> followers;
    map<int, vector<pair<int,int>>> tweets;
    int tweetFeedCount;
    int currTweetCount;
    Twitter() {
        tweetFeedCount = 10;
        currTweetCount = 0;
    }
    
    void insertIntoPq(priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>&pq, 
    vector<pair<int,int>>&posts){
        int postsSize = posts.size();
        for(int i=0; i<postsSize; i++){
            if(pq.size() < tweetFeedCount){
                pq.push(posts[i]);
            }
            else if(pq.size() == tweetFeedCount){
                if(pq.top().first < posts[i].first){
                    pq.pop();
                    pq.push(posts[i]);
                }
            }
        }
    }

    void postTweet(int userId, int tweetId) {
        vector<pair<int,int>> posts = tweets[userId];
        posts.push_back({currTweetCount+1, tweetId});
        tweets[userId] = posts;
        currTweetCount++;
    }
    
    vector<int> getNewsFeed(int userId) {
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

        if(tweets.find(userId) != tweets.end()){
            vector<pair<int,int>> posts = tweets[userId];
            insertIntoPq(pq, posts);
        }
        
        if(followers.find(userId) != followers.end()){
            set<int> friends = followers[userId];
            if(friends.size()>0){
                for(auto follower: friends){
                    vector<pair<int,int>> friendPosts = tweets[follower];
                    insertIntoPq(pq, friendPosts);
                }
            }
        }
        
        vector<int> feed;
        while(pq.size()>0){
            pair<int,int> post = pq.top();
            pq.pop();
            feed.push_back(post.second);
        }

        reverse(feed.begin(), feed.end());
        return feed;
    }
    
    void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        set<int>users;
        if(followers.find(followerId) != followers.end()){
            users = followers[followerId];
        }
        
        users.insert(followeeId);
        followers[followerId] = users;
    }
    
    void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        set<int>users;
        if(followers.find(followerId) != followers.end()){
            users = followers[followerId];
        }
        if(users.size() == 0) return;
        users.erase(users.find(followeeId));
        followers[followerId] = users;
    }
};
