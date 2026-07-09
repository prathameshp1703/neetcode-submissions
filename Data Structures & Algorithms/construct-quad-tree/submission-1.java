/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    private boolean checkEqual(int[][] grid, int startRow, int endRow,
     int startCol, int endCol){

        for(int i=startRow; i<=endRow; i++){
            for(int j=startCol; j<=endCol; j++){
                if(grid[i][j] != grid[startRow][startCol]){
                    return false;
                }
            }
        }

        return true;
    }

    private Node solve(int[][]grid, int startRow,
        int endRow, int startCol, int endCol){
        if(startRow >= endRow || startCol>=endCol) return new Node(grid[startRow][startCol] == 1, true);
        // System.out.println(startRow + " " + endRow + " " + startCol + " " + endCol);
        boolean isEqual = checkEqual(grid, startRow, endRow, startCol, endCol);
        if(isEqual){
            return new Node(grid[startRow][startCol] == 1, true);
        }
        Node currNode = new Node(grid[startRow][startCol] == 1, false);
        int midRow = startRow + (endRow-startRow)/2;
        int midCol = startCol + (endCol-startCol)/2;

        currNode.topLeft = solve(grid, startRow, midRow, startCol, midCol);
        currNode.topRight = solve(grid, startRow, midRow, 1+midCol, endCol);
        currNode.bottomLeft = solve(grid, 1+midRow, endRow, startCol, midCol);
        currNode.bottomRight = solve(grid, 1+midRow, endRow, 1+midCol, endCol);

        return currNode;
    }
    public Node construct(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows == 1 && cols == 1) return new Node(grid[0][0] == 1, true);

        return solve(grid, 0, rows-1, 0, cols-1);
    }
}