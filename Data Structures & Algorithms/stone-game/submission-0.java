class Solution {

    private int stoneGameHelper(int index1, int index2, int[] piles, int[][] dp){
        if(index1 == index2){
            return piles[index1];
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        int pickFront = piles[index1] - stoneGameHelper(index1+1, index2, piles, dp);
        int pickBack = piles[index2] - stoneGameHelper(index1, index2-1, piles, dp);

        return dp[index1][index2] = Math.max(pickFront, pickBack);
    }

    public boolean stoneGame(int[] piles) {
        int size = piles.length;
        int index1 = 0; int index2 = size-1;

        int[][] dp = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                dp[i][j] = -1;
            }
        }

        int ans = stoneGameHelper(index1, index2, piles, dp);
        if(ans > 0) return true;
        return false;
    }
}