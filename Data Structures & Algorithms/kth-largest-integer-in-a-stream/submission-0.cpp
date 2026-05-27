class KthLargest {
public:
    priority_queue<int, vector<int>, greater<int>> pq;
    int K;
    KthLargest(int k, vector<int>& nums) {
        K = k;
        int size = nums.size();
        for(int i=0; i<size; i++){
            if(pq.size() == k){
                if(pq.top()<nums[i]){
                    pq.pop();
                    pq.push(nums[i]);
                }
            }
            else{
                pq.push(nums[i]);
            }
        }
    }
    
    int add(int val) {
        if(pq.size() == K){
            if(pq.top()<val){
                pq.pop();
                pq.push(val);
            }
        }
        else{
            pq.push(val);
        }
        return pq.top();
    }
};
