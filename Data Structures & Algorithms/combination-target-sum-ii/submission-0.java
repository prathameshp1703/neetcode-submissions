class Solution {
    private void solve(int index, List<Integer> currList, int[] candidates, 
    List<List<Integer>> ans, int target){
        if(index >= candidates.length){
            if(target == 0){
                List<Integer> temp = new ArrayList<>(currList);
                ans.add(temp);
            }
            return;
        }
        int currIndex = index+1;
        while(currIndex < candidates.length && candidates[currIndex] == candidates[index]){
            currIndex++;
        }
        solve(currIndex, currList, candidates, ans, target);

        if(target-candidates[index] >= 0){
            currList.add(candidates[index]);
            solve(index+1, currList, candidates, ans, target-candidates[index]);
            currList.remove(Integer.valueOf(candidates[index]));
        }

        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        List<Integer> currList = new ArrayList<>();
        solve(index, currList, candidates, ans, target);

        return ans;
    }
}
