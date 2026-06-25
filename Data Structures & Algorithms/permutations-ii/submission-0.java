class Solution {

    private void solve(int index, List<Integer> curr, int[] nums, 
        Map<Integer, Integer> occ, List<List<Integer>> ans){
        
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : occ.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > 0){
                curr.add(key);
                occ.put(key, occ.get(key)-1);
                solve(index+1, curr, nums, occ, ans);
                occ.put(key, occ.get(key)+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0; int size = nums.length;

        List<Integer> curr = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<size; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        solve(index, curr, nums, freq, ans);

        return ans;
    }
}