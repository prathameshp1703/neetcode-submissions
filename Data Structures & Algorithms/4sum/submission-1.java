class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int size = nums.length;
        for(int i=0; i<size; i++){
            if(i-1>=0 && nums[i-1] == nums[i]){
                continue;
            }
            for(int j=i+1; j<size; j++){
                if(j-1 > i && nums[j-1] == nums[j]){
                    continue;
                }

                int left = j+1; int right = size-1;
                while(left<right){
                    if(left-1 > j && nums[left] == nums[left-1]){
                        left++; continue;
                    }
                    if(right+1 < size && nums[right] == nums[right+1]){
                        right--; continue;
                    }
                    long currSum = (long) nums[i] + (long)nums[j] + 
                    (long)nums[left] + (long)nums[right];
                    if(currSum == target){
                        List<Integer> curr = new ArrayList<>(List.of(nums[i], nums[j],
                         nums[left], nums[right]));
                        ans.add(curr);
                        left++; right--;
                    }
                    else if(currSum > target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }

        return ans;
    }
}