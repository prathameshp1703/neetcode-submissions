class Solution {
    class Pair{
        int index1; 
        int index2;

        Pair(int index1, int index2){
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    private int INF = 2147483647;
    private int[] dx = {1, -1, 0 , 0};
    private int[] dy = {0, 0, 1, -1};

    private boolean isValid(int index1, int index2, int rows, int cols){
        if(index1 <0 || index2 < 0 || index1 >= rows || index2 >= cols){
            return false;
        }
        return true;
    }

    public void islandsAndTreasure(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> curr = new LinkedList<>();
        int[][] visited = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0){
                    curr.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int ans = 0;
        while(curr.size()>0){
            int size = curr.size();
            for(int i=0; i<size; i++){
                Pair front = curr.poll();
                grid[front.index1][front.index2] = ans;
                for(int j=0; j<4; j++){
                    int newIndex1 = front.index1 + dx[j];
                    int newIndex2 = front.index2 + dy[j];

                    if(isValid(newIndex1, newIndex2, rows, cols) && grid[newIndex1][newIndex2] == INF && visited[newIndex1][newIndex2] == 0){
                        visited[newIndex1][newIndex2] = 1;
                        curr.add(new Pair(newIndex1, newIndex2));
                    }
                }
            }
            ans++;
        }
    }
}
