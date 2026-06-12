class Solution {

    private void solve(List<Integer> curr, List<List<Integer>> ans,
     HashMap<Integer, Integer> freq, int[]nums){
        if(curr.size() == nums.length){
            List<Integer> temp = new ArrayList<>(curr);
            ans.add(temp);
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!freq.containsKey(nums[i])){
                freq.put(nums[i], 1);
                curr.add(nums[i]);
                solve(curr, ans, freq, nums);
                curr.remove(Integer.valueOf(nums[i]));
                freq.remove(nums[i]);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        List<Integer> curr = new ArrayList<>();
        solve(curr, ans, freq, nums);

        return ans;
    }
}
