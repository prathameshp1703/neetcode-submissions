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
    private int count;
    private int res;
    private void solve(TreeNode root){
        if(root == null) return;
        solve(root.left);
        count--;
        if(count == 0){
            res = root.val;
        }
        solve(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = -1;
        solve(root);
        return res;
    }
}
