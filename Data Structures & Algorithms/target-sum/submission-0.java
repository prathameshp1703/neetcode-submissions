class Solution {

    class NumsInfo{
        int index;
        int currSum;

        public NumsInfo(int index, int currSum){
            this.index = index;
            this.currSum = currSum;
        }

        public boolean equals(Object obj){
            if(this == obj) return true;
            if(!(obj instanceof NumsInfo)) return false;

            NumsInfo curr = (NumsInfo) obj;
            return (this.index == curr.index && this.currSum == curr.currSum);
        }

        public int hashcode(){
            return Objects.hash(index, currSum);
        }
    }

    private int findTargetSumWaysHelper(int index, int currSum, int target, int[] nums, Map<NumsInfo, Integer> dp){
        if(index == nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }
        NumsInfo curr = new NumsInfo(index, currSum);

        if(dp.containsKey(curr)){
            return dp.get(curr);
        }
        int add = 0; int sub = 0;

        add += findTargetSumWaysHelper(index+1, currSum+nums[index], target, nums, dp);
        sub += findTargetSumWaysHelper(index+1, currSum-nums[index], target, nums, dp);

        dp.put(curr, (add+sub));
        return (add+sub);
    }

    public int findTargetSumWays(int[] nums, int target) {
        
        int currSum = 0; int index = 0;
        Map<NumsInfo, Integer> dp = new HashMap<>();
        return findTargetSumWaysHelper(index, currSum, target, nums, dp);
    }
}
