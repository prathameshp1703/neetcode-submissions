class Solution {
    int [] dx = {1, -1, 0, 0};
    int [] dy = {0, 0, 1, -1};

    private boolean isValid(int index1, int index2, int n, int m){
        if(index1 < 0 || index2 < 0 || index1 >= n || index2 >= m){
            return false;
        }
        return true;
    }

    private boolean solve(int index1, int index2, int curr, char[][] board,
        String word, int rows, int cols, int[][] visited){
        if(curr == word.length()-1){
            if(board[index1][index2] == word.charAt(curr)){
                return true;
            }
            return false;
        }   

        if(board[index1][index2] != word.charAt(curr)){
            return false;
        }
        visited[index1][index2] = 1;
        for(int i=0; i<4; i++){
            int curr1 = index1+dx[i];
            int curr2 = index2+dy[i];

            if(isValid(curr1, curr2, rows, cols) && visited[curr1][curr2] == 0){
                
                if(solve(curr1, curr2, curr+1, board, word, rows, cols, visited)){
                    return true;
                }
            }
        }
        visited[index1][index2] = 0;
        return false;
    }


    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int visited[][] = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                visited[i][j] = 0;
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(i, j, 0, board, word, rows, cols, visited)) return true;
                }
            }
        }

        return false;
    }
}
