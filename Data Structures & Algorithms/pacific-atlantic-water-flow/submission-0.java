class Solution {

    private int dx[] = {1, -1, 0, 0};
    private int dy[] = {0, 0, 1, -1};

    private boolean isValid(int index1, int index2, int rows, int cols){
        if(index1<0 || index2<0 || index1>=rows || index2>=cols){
            return false;
        }
        return true;
    }

    private void pacificAtlanticHelper(int index1, int index2, int rows, int cols, int[][] heights, int[][] visited){
        visited[index1][index2] = 1;
        for(int i=0; i<4; i++){
            int newIndex1 = index1 + dx[i];
            int newIndex2 = index2 + dy[i];

            if(isValid(newIndex1, newIndex2, rows, cols) && (visited[newIndex1][newIndex2] == 0) && (heights[newIndex1][newIndex2] >= heights[index1][index2])){
                pacificAtlanticHelper(newIndex1, newIndex2, rows, cols, heights, visited);
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        int[][] pacific = new int[rows][cols];
        int[][] atlantic = new int[rows][cols];

        for(int i=0; i<rows; i++) pacificAtlanticHelper(i, 0, rows, cols, heights, pacific);
        for(int i=0; i<cols; i++) pacificAtlanticHelper(0, i, rows, cols, heights, pacific);

        for(int i=0; i<rows; i++) pacificAtlanticHelper(i, cols-1, rows, cols, heights, atlantic);
        for(int i=0; i<cols; i++) pacificAtlanticHelper(rows-1, i, rows, cols, heights, atlantic);

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }
}
