class Solution {
    private int integerBreakHelper(int n, int isFirst, int[][] dp){
        if(n == 0) return 1;

        if(dp[n][isFirst] != -1){
            return dp[n][isFirst];
        }
        int curr = 1;
        int end = (isFirst == 1) ? n-1 : n;
        for(int i=1; i<=end; i++){
            if((n-i) >= 0){
                curr = Math.max(curr, i*integerBreakHelper(n-i, 0, dp));
            }
        }

        return dp[n][isFirst] = curr;
    }

    public int integerBreak(int n) {
        
        int[][] dp = new int[n+1][2];
        int isFirst = 1;
        for(int i=0; i<=n; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }
        
        return integerBreakHelper(n, isFirst, dp);
    }
}