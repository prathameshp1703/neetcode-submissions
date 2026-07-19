class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private boolean isValid(int index1, int index2, int rows, int cols){
        if(index1 < 0 || index2 < 0 || index1 >= rows || index2 >= cols){
            return false;
        }
        return true;
    }

    private int longestIncreasingPathHelper(int index1, int index2, int[][] matrix,
     int[][] dp, int rows, int cols){

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        int ans = 1;
        for(int i=0; i<4; i++){
            int newIndex1 = index1 + dx[i];
            int newIndex2 = index2 + dy[i];

            if(isValid(newIndex1, newIndex2, rows, cols) && 
                matrix[newIndex1][newIndex2] > matrix[index1][index2]){
                ans = Math.max(ans, 1 + longestIncreasingPathHelper(newIndex1, newIndex2,
                    matrix, dp, rows, cols));
            }
        }
        return dp[index1][index2] = ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                ans = Math.max(ans, longestIncreasingPathHelper(i, j, matrix, dp, rows, cols));
            }
        }

        return ans;
    }
}
