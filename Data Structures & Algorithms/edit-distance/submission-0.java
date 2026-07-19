class Solution {

    private int minDistanceHelper(int index1, int index2, String word1, String word2, int[][] dp){
        if(index1 == word1.length() || index2 == word2.length()){
            if(index1 == word1.length()){
                return (word2.length()-index2);
            }
            return (word1.length()-index1);
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        int pick = (int) 1e9; int insert = (int) 1e9;
        int delete = (int) 1e9; int replace = (int) 1e9;
        if(word1.charAt(index1) == word2.charAt(index2)){
            pick = minDistanceHelper(index1+1, index2+1, word1, word2, dp);
        }
        insert = 1 + minDistanceHelper(index1, index2+1, word1, word2, dp);
        delete = 1 + minDistanceHelper(index1+1, index2, word1, word2, dp);
        replace = 1 + minDistanceHelper(index1+1, index2+1, word1, word2, dp);

        return dp[index1][index2] = Math.min(Math.min(pick, delete), Math.min(insert, replace));
    }

    public int minDistance(String word1, String word2) {
        int index1 = 0; int index2 = 0;
        int size1 = word1.length(); int size2 = word2.length();
        int[][] dp = new int[size1][size2];

        for(int i=0; i<size1; i++){
            for(int j=0; j<size2; j++){
                dp[i][j] = -1;
            }
        }
        return minDistanceHelper(index1, index2, word1, word2, dp);
    }
}
