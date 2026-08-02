class Solution {
    class Pair{
        int index1; 
        int index2;

        Pair(int index1, int index2){
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    private int[] dx = {1, -1, 0 , 0};
    private int[] dy = {0, 0, 1, -1};

    private boolean isValid(int index1, int index2, int rows, int cols){
        if(index1 <0 || index2 < 0 || index1 >= rows || index2 >= cols){
            return false;
        }
        return true;
    }

    private int maxAreaOfIslandHelper(int index1, int index2, int[][] grid, int val, int[][] visited){
        Queue<Pair> curr = new LinkedList<>();
        curr.add(new Pair(index1, index2));
        int ans = 0;
        visited[index1][index2] = 1;
        while(curr.size()>0){
            Pair front = curr.poll();
            ans++;
            
            
            for(int i=0; i<4; i++){
                int newIndex1 = front.index1 + dx[i];
                int newIndex2 = front.index2 + dy[i];

                if(isValid(newIndex1, newIndex2, grid.length, grid[0].length) && grid[newIndex1][newIndex2] == val && visited[newIndex1][newIndex2] == 0){
                    visited[newIndex1][newIndex2] = 1;
                    curr.add(new Pair(newIndex1, newIndex2));
                }
            }
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                visited[i][j] = 0;
            }
        }

        int ans = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ans = Math.max(ans, maxAreaOfIslandHelper(i, j, grid, grid[i][j], visited));
                }
            }
        }

        return ans;
    }
}
