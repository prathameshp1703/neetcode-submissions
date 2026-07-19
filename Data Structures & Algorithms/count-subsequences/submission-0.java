class Solution {

    private int numDistinctHelper(int index1, int index2, String s, String t, int[][] dp){
        if(index2 == t.length()){
            return 1;
        }
        if(index1 == s.length() && index2 != t.length()){
            return 0;
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        int pick = 0; int notPick = 0;
        if(s.charAt(index1) == t.charAt(index2)){
            pick = numDistinctHelper(index1+1, index2+1, s, t, dp);
        }
        notPick = numDistinctHelper(index1+1, index2, s, t, dp);

        return dp[index1][index2] = (pick + notPick);
    }

    public int numDistinct(String s, String t) {
        int index1 = 0; int index2 = 0;
        int size1 = s.length(); int size2 = t.length();

        int[][] dp = new int[size1][size2];
        for(int i=0; i<size1; i++){
            for(int j=0; j<size2; j++){
                dp[i][j] = -1;
            }
        }

        return numDistinctHelper(index1, index2, s, t, dp);
    }
}
