class Solution {

    void solve(int index, List<Integer> curr, List<List<Integer>> ans, int[] nums){
        // System.out.println(index);
        if(index >= nums.length){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(curr);
            ans.add(temp);
            return;
        }
        int nextIndex = index+1;
        while(nextIndex < nums.length && nums[nextIndex] == nums[index]){
            nextIndex++;
        }
        solve(nextIndex, curr, ans, nums);
        curr.add(nums[index]);
        solve(index+1, curr, ans, nums);
        // System.out.println("Index " + index);
        curr.remove(Integer.valueOf(nums[index]));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(index, curr, ans, nums);

        return ans;
    }
}
