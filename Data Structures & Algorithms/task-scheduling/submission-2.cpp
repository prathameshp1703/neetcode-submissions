class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        map<char, int> freq;
        int size = tasks.size();
        for(int i=0; i<size; i++){
            freq[tasks[i]]++;
        }
        priority_queue<pair<int,int>, vector<pair<int,int>>> pq;
        for(auto i: freq){
            pq.push({i.second, i.first-'A'});
        }

        int currIndex = 0;
        vector<char> v;
        multiset<int> occ;
        while(pq.size()>0){
            if((currIndex-n-1) >= 0){
                occ.erase(occ.find(v[(currIndex-n-1)]-'A'));
            }
            vector<pair<int,int>> dup;
            int flag = 0;
            while(pq.size()>0){
                pair<int,int> temp = pq.top(); pq.pop();
                if(occ.find(temp.second) != occ.end()){
                    dup.push_back(temp);
                }
                else{
                    v.push_back(temp.second + 'A');
                    occ.insert(temp.second);
                    flag = 1;
                    if((temp.first-1) > 0){
                        dup.push_back({temp.first-1, temp.second});
                    }
                    break;
                }
            }
            if(flag == 0){
                v.push_back('-');
                occ.insert('-' - 'A');
            }
            for(int i=0; i<dup.size(); i++){
                pq.push(dup[i]);
            }
            currIndex++;
        }
        return currIndex++;
    }
};
