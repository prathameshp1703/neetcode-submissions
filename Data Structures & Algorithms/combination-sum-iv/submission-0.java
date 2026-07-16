class Solution {
    private int combinationSumHelper(int[] nums, int target, int[] dp){
        if(target == 0) return 1;

        if(dp[target] != -1){
            return dp[target];
        }
        int total = 0;
        for(int num: nums){
            if(target-num >=0){
                total += combinationSumHelper(nums, target-num, dp);
            }
        }

        return dp[target] = total;
    }

    public int combinationSum4(int[] nums, int target) {

        int [] dp = new int[target+1];
        for(int i=0; i<=target; i++){
            dp[i] = -1;
        }
        return combinationSumHelper(nums, target, dp);
    }
}