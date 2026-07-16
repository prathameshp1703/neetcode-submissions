class Solution {
    private boolean canPartitionHelper(int index, int currSum, int totalSum,
     int[] nums, int[][]dp){
        if(index == nums.length){
            return ((totalSum-currSum) == currSum) ? true : false;
        }

        if(dp[index][currSum] != -1){
            return dp[index][currSum] == 1 ? true : false;
        } 
        boolean pick = false; boolean notPick = false;
        pick = canPartitionHelper(index+1, currSum+nums[index], totalSum, nums, dp);
        notPick = canPartitionHelper(index+1, currSum, totalSum, nums, dp);
        dp[index][currSum] = (pick || notPick) == true ? 1 : 0;
        return (pick || notPick);
    }   

    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int totalSum = 0;
        int index = 0; int currSum = 0;
        for(int i=0; i<size; i++){
            totalSum += nums[i];
        }
        int[][] dp = new int[size][totalSum+1];
        for(int i=0; i<size; i++){
            for(int j=0; j<=totalSum; j++){
                dp[i][j] = -1;
            }
        }
        return canPartitionHelper(index, currSum, totalSum, nums, dp);
    }
}
