class Solution {

    private void solve(List<Integer> curr, int[] nums, 
        boolean[] visited, List<List<Integer>> ans){
        
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(i-1>=0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                solve(curr, nums, visited, ans);
                visited[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int size = nums.length;

        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[size];

        solve(curr, nums, visited, ans);
        return ans;
    }
}