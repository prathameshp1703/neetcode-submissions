class Solution {

    private int lengthOfLISHelper(int index, int prev, int[] nums, int[][]dp){
        if(index == nums.length){
            return 0;
        }
        if(dp[index][prev+1] != -1){
            return dp[index][prev+1];
        }

        int take = 0; int notTake = 0;
        if(prev == -1 || nums[prev] < nums[index]){
            take = 1 + lengthOfLISHelper(index+1, index, nums, dp);
        }
        notTake = lengthOfLISHelper(index+1, prev, nums, dp);

        return dp[index][prev+1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int index = 0;
        int prev = -1;

        int[][] dp = new int[size+1][size+1];
        for(int i=0; i<=size; i++){
            for(int j=0; j<=size; j++){
                dp[i][j] = -1;
            }
        }
        return lengthOfLISHelper(index, prev, nums, dp);
    }
}
