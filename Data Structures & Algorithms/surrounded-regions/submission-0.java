class Solution {

    private int dx[] = {1, -1, 0, 0};
    private int dy[] = {0, 0, 1, -1};

    private boolean isValid(int index1, int index2, int rows, int cols){
        if(index1<0 || index2<0 || index1>=rows || index2>=cols){
            return false;
        }
        return true;
    }

    private void surroundedRegionHelper(int index1, int index2, int rows, int cols, char[][] board, int[][] visited){
        visited[index1][index2] = 1;
        for(int i=0; i<4; i++){
            int newIndex1 = index1 + dx[i];
            int newIndex2 = index2 + dy[i];

            if(isValid(newIndex1, newIndex2, rows, cols) && (visited[newIndex1][newIndex2] == 0) && board[newIndex1][newIndex2] == 'O'){
                surroundedRegionHelper(newIndex1, newIndex2, rows, cols, board, visited);
            }
        }

    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];

        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O'){
                surroundedRegionHelper(i, 0, rows, cols, board, visited);
            }
        } 
        for(int i=0; i<cols; i++){
            if(board[0][i] == 'O'){
                surroundedRegionHelper(0, i, rows, cols, board, visited);
            }
        } 

        for(int i=0; i<rows; i++){
            if(board[i][cols-1] == 'O'){
                surroundedRegionHelper(i, cols-1, rows, cols, board, visited);
            }
        } 

        for(int i=0; i<cols; i++){
            if(board[rows-1][i] == 'O'){
                surroundedRegionHelper(rows-1, i, rows, cols, board, visited);
            }
        } 

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(visited[i][j] != 1){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
