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
    private boolean solve(TreeNode root, int left, int right){
        if(root == null) return true;
        if(root.val >= right || root.val <=left) return false;

        boolean leftValid = solve(root.left, left, root.val);
        boolean rightValid = solve(root.right, root.val, right);

        return leftValid && rightValid;
    }

    public boolean isValidBST(TreeNode root) {
        int left = Integer.MIN_VALUE; int right = Integer.MAX_VALUE;
        return solve(root, left, right);
    }
}
