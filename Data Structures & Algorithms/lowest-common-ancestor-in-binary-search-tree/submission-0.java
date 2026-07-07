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
    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = solve(root, p, q);

        return ans;
    }
}
