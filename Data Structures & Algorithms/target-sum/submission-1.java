class Solution {

    private int findTargetSumWaysHelper(int index, int currSum, int total, int target, int[] nums, int[][] dp){
        if(index == nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }
        if(dp[index][currSum+total] != -1){
            return dp[index][currSum+total];
        }
        int add = 0; int sub = 0;

        add += findTargetSumWaysHelper(index+1, currSum+nums[index], total, target, nums, dp);
        sub += findTargetSumWaysHelper(index+1, currSum-nums[index], total, target, nums, dp);

        return dp[index][currSum+total] = (add+sub);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int size = nums.length;
        int currSum = 0; int index = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int[][] dp = new int[size][2*sum+1];

        for(int i=0; i<size; i++){
            for(int j=0; j<=2*sum; j++){
                dp[i][j] = -1;
            }
        }
        return findTargetSumWaysHelper(index, currSum, sum, target, nums, dp);
    }
}
