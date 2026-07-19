class Solution {

    private int longestCommonSubsequenceHelper(int index1, int index2, String text1,
       String text2, int[][] dp){

        if(index1 == text1.length() || index2 == text2.length()) return 0;

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        int pick = 0; int notPick = 0;
        if(text1.charAt(index1) == text2.charAt(index2)){
            pick = 1 + longestCommonSubsequenceHelper(index1+1, index2+1, text1, text2, dp);
        }
        notPick = Math.max(longestCommonSubsequenceHelper(index1+1, index2, text1, text2, dp), 
            longestCommonSubsequenceHelper(index1, index2+1, text1, text2, dp));

        return dp[index1][index2] = Math.max(pick, notPick);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int index1 = 0; int index2 = 0;
        int size1 = text1.length(); int size2 = text2.length();
        int[][] dp = new int[size1][size2];

        for(int i=0; i<size1; i++){
            for(int j=0; j<size2; j++){
                dp[i][j] = -1;
            }
        }
        return longestCommonSubsequenceHelper(index1, index2, text1, text2, dp);
    }
}
