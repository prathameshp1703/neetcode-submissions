class Solution {

    int[] dx = {1, 0};
    int[] dy = {0, 1};

    private boolean isValid(int index1, int index2, int rows, int cols){
        if(index1 < 0 || index2 < 0 || index1 >= rows || index2 >= cols){
            return false;
        }
        return true;
    }

    private int minPathSumHelper(int index1, int index2, int[][] dp, int[][] grid, int rows, int cols){
        
        if(index1 == rows-1 && index2 == cols-1){
            return grid[index1][index2];
        }
        
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        int ans = (int) 1e9;
        for(int i=0; i<2; i++){
            int newIndex1 = index1 + dx[i];
            int newIndex2 = index2 + dy[i];

            if(isValid(newIndex1, newIndex2, rows, cols)){
                ans = Math.min(ans, grid[index1][index2] + minPathSumHelper(newIndex1, newIndex2, dp, grid, rows, cols));
            }
        }

        return dp[index1][index2] = ans;
    }

    public int minPathSum(int[][] grid) {
        int index1 = 0; int index2 = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i][j] = -1;
            }
        }

        int ans = minPathSumHelper(index1, index2, dp, grid, rows, cols);

        return ans;
    }
}