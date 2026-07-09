/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int solve(TreeNode root, int currMax){
        if(root == null) return 0;

        int count = (root.val >= currMax) ? 1 : 0;
        currMax = Math.max(currMax, root.val);
        
        int left = solve(root.left, currMax);
        int right = solve(root.right, currMax);

        return count + left + right;
    }

    public int goodNodes(TreeNode root) {
        int currMax = (int) -1e9;
        return solve(root, currMax);
    }
}
