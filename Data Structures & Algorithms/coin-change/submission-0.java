class Solution {

    private int coinChangeHelper(int index, int[] coins, int amount, int[][] dp){
        if(index == coins.length){
            if(amount == 0) return 0;
            return (int) 1e9;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int take = (int)1e9; int notTake = (int) 1e9;
        if(amount-coins[index]>=0){
            take = 1+coinChangeHelper(index, coins, amount-coins[index], dp);
        }
        notTake = coinChangeHelper(index+1, coins, amount, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int index = 0;
        int size = coins.length;
        int[][] dp = new int[size][amount+1];
        for(int i=0; i<size; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }
        int ans = coinChangeHelper(index, coins, amount, dp);
        if(ans == (int)1e9) ans = -1;
        return ans;
    }
}
