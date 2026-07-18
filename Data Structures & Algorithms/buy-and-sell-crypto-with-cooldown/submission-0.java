class Solution {
    private int maxProfitHelper(int index, int prevAction, int[] prices, int[][] dp){
        if(index >= prices.length){
            return 0;
        }

        if(dp[index][prevAction+1] != -1){
            return dp[index][prevAction+1];
        }
        int buy = 0; int sell = 0; int hold = 0;
        if(prevAction == -1 || prevAction == 1){
            buy = (prices[index]*-1) + maxProfitHelper(index+1, 0, prices, dp);
        }
        if(prevAction == 0){
            sell = prices[index] + maxProfitHelper(index+2, 1, prices, dp);
        }
        hold = maxProfitHelper(index+1, prevAction, prices, dp);

        return dp[index][prevAction+1] = Math.max(buy, Math.max(sell, hold));
    }

    public int maxProfit(int[] prices) {
        int prevAction = -1;
        int index = 0;
        int size = prices.length;
        int[][] dp = new int[size+1][3];

        for(int i=0; i<=size; i++){
            for(int j=0; j<=2; j++){
                dp[i][j] = -1;
            }
        }
        return maxProfitHelper(index, prevAction, prices, dp);
    }
}
