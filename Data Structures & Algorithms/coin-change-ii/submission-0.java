class Solution {
    private int changeHelper(int index, int[] coins, int amount, int[][] dp){
        
        if(index >= coins.length){
            if(amount == 0) return 1;
            return 0;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int take = 0; int notTake = 0;
        if((amount-coins[index]) >= 0){
            take = changeHelper(index, coins, amount-coins[index], dp);
        }
        int nextIndex = index+1;
        
        while(nextIndex<coins.length && coins[nextIndex] == coins[index]){
            nextIndex++;
        }
        notTake = changeHelper(nextIndex, coins, amount, dp);
        
        return dp[index][amount] = (take+notTake);
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int index = 0;
        int size = coins.length;
        int[][] dp = new int[size][amount+1];
        for(int i=0; i<size; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = -1;
            }
        }

        return changeHelper(index, coins, amount, dp);
    }
}
