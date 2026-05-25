class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        int size = nums.size();
        int ans;
        for(int i=0; i<size; i++){
            if(pq.size()<k){
                pq.push(nums[i]);
            }
            else{
                if(nums[i] > pq.top()){
                    pq.pop();
                    pq.push(nums[i]);
                }
            }
        }

        ans = pq.top();
        return ans;
    }
};
