class Solution {
    private int robHelper(int start, int end, int[] nums, int firstPicked, int[][] dp){
        if(start >= end) return 0;

        int take = 0; int notTake = 0;
        if(dp[start][firstPicked+1] != -1){
            return dp[start][firstPicked+1];
        }

        if(start == 0){
            take = nums[start] + robHelper(start+2, end, nums, 1, dp);
            notTake = robHelper(start+1, end, nums, 0, dp);
        }
        else{
            if(start == end-1 && firstPicked == 1){
                take = robHelper(start+1, end, nums, firstPicked, dp);
            }
            else{
                take = nums[start] + robHelper(start+2, end, nums, firstPicked, dp);
            }
            notTake = robHelper(start+1, end, nums, firstPicked, dp);
        }

       
        return dp[start][firstPicked+1] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int start = 0; int end = nums.length;
        if(start == end) return nums[start];

        int[][] dp = new int[size][3];
        for(int i=0; i<size; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = -1;
            }
        }

        return robHelper(start, end, nums, -1, dp);
    }
}
