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

    private TreeNode getLeftNode(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    private TreeNode solve(TreeNode root, int key){
        if(root == null) return root;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode rightsLeft = getLeftNode(root.right);
            rightsLeft.left = root.left;
            return root.right;
        }
        TreeNode left = solve(root.left, key);
        TreeNode right = solve(root.right, key);
        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return solve(root, key);
    }
}