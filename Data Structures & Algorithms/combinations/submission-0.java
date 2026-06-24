class Solution {

    private void solve(int index, List<Integer> curr, List<Integer> nums,
     int k, List<List<Integer>> ans){

        if(index == nums.size()){
            if(curr.size() == k){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(nums.get(index));
        solve(index+1, curr, nums, k, ans);
        curr.remove(curr.size()-1);
        solve(index+1, curr, nums, k, ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++){
            nums.add(i+1);
        }
        int index = 0;
        List<Integer> curr = new ArrayList<>();
        solve(index, curr, nums, k, ans);
        return ans;
    }
}