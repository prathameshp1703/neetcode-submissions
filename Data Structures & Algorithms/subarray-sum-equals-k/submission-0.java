class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        int currSum = 0;
        lookup.put(currSum, new ArrayList<>(Collections.nCopies(1, -1)));
        int size = nums.length;
        int ans = 0;
        for(int i=0; i<size; i++){
            currSum += nums[i];
            if(lookup.containsKey(currSum-k)){
                ans+=(lookup.get(currSum-k).size());
            }
            if(!lookup.containsKey(currSum)){
                lookup.put(currSum, new ArrayList<>(Collections.nCopies(1, i)));
            }
            else{
                lookup.get(currSum).add(i);
            }
        }

        return ans;
    }
}