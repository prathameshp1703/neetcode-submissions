class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int size = nums.length;
        for(int i=0; i<size; i++){
            if(i-1 >= 0 && nums[i-1] == nums[i]){
                continue;
            }
            int j = i+1; int k = size-1;
            while(j<k){
                if(j-1 > i && nums[j-1] == nums[j]){
                    j++; continue;
                }
                if(k+1 < size && nums[k] == nums[k+1]){
                    k--; continue;
                }
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum == 0){
                    List<Integer> curr = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                    ans.add(curr);
                    j++; k--;
                }
                else if(currSum > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return ans;
    }
}
