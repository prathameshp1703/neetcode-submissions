class Solution {
    private int numSquaresHelper(int curr, int n, int[][] dp){
        if(n == 0) return 0;
        if(curr == 1) return n;

        if(dp[curr][n] != -1){
            return dp[curr][n];
        }
        int pick = (int) 1e9; int notPick = (int) 1e9;
        int currSquare = (curr*curr);
        if(n-currSquare >= 0){
            pick = 1 + numSquaresHelper(curr, (n-currSquare), dp);
        }
        notPick = numSquaresHelper(curr-1, n, dp);

        return dp[curr][n] = Math.min(pick, notPick);
        
    }
    public int numSquares(int n) {
        int maxSquare = (int)Math.sqrt(n);
        int[][] dp = new int[maxSquare+1][n+1];

        for(int i=0; i<=maxSquare; i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        return numSquaresHelper(maxSquare, n, dp);
    }
}