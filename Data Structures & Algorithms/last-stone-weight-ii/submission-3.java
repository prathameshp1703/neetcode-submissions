class Solution {

    private int lastStoneWeightHelper(int index, int currVal, int[]stones, int[][] dp, int totalSum){
        if(index == stones.length){
            int remVal = totalSum - currVal;
            return Math.abs(remVal - currVal);
        }

        if(dp[index][currVal] != -1){
            return dp[index][currVal];
        }

        int take = lastStoneWeightHelper(index+1, currVal+stones[index], stones, dp, totalSum);
        int notTake = lastStoneWeightHelper(index+1, currVal, stones, dp, totalSum);

        
        return dp[index][currVal] = Math.min(take, notTake);
    }
    
    public int lastStoneWeightII(int[] stones) {
        int size = stones.length;
        int index = 0;
        int currVal = 0;
        int totalSum = 0;
        for(int i=0; i<size; i++){
            totalSum += stones[i];
        }
        
        int[][] dp = new int[size][totalSum+1];
        for(int i=0; i<size; i++){
            for(int j=0; j<totalSum; j++){
                dp[i][j] = -1;
            }
        }

        return lastStoneWeightHelper(index, currVal, stones, dp, totalSum);
    }
}