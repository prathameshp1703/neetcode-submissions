class Solution {
    private int stoneGameHelper(int index, int M, int[] piles, int[][] dp){
        if(index >= piles.length){
            return 0;
        }

        if(dp[index][M] != -1){
            return dp[index][M];
        }
        int ans = (int) -1e9;
        int currTotal = 0;
        for(int i=0; i<(2*M); i++){
            if((i+index) < piles.length){
                currTotal += piles[i+index];
                ans = Math.max(ans, currTotal - stoneGameHelper(i+index+1, Math.max(M, (i+1)), piles, dp));
            }
        }

        return dp[index][M] = ans;
    }

    public int stoneGameII(int[] piles) {
        int index = 0;
        int M = 1;
        int size = piles.length;
        int[][] dp = new int[size][129];

        for(int i=0; i<size; i++){
            for(int j=0; j<129; j++){
                dp[i][j] = -1;
            }
        }
        int ans = stoneGameHelper(index, M, piles, dp);
        // System.out.println(ans);
        int sum = 0;
        for(int pile : piles){
            sum += pile;
        }
        return (ans + sum)/2;
    }
}