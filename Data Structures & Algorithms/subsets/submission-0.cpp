class Solution {
public:

    void solve(int index, vector<int> &nums, vector<vector<int>> & ans, 
    vector<int>&curr){
        if(index >= nums.size()){
            ans.push_back(curr);
            return;
        }
        curr.push_back(nums[index]);
        solve(index+1, nums, ans, curr);
        curr.pop_back();
        solve(index+1, nums, ans, curr);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        int index = 0;
        vector<int>curr;
        solve(index, nums, ans, curr);
        return ans;
    }
};
