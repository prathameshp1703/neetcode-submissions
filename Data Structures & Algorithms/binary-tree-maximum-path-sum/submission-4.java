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
    private int ans;
    private int solve(TreeNode root){
        if(root == null) return 0;

        int leftMax = Math.max(0, solve(root.left));
        int rightMax = Math.max(0, solve(root.right));
        ans = Math.max(ans, Math.max(root.val, root.val + leftMax + rightMax));
        return Math.max(root.val, root.val+Math.max(leftMax, rightMax));
    }
    public int maxPathSum(TreeNode root) {
        ans = (int)-1e9;
        solve(root);
        return ans;
    }
}
