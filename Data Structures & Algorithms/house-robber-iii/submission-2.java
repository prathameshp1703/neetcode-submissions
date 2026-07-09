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

    private int solve(TreeNode root, Map<TreeNode,Integer> lookup){
        if(root == null) return 0;
        if(lookup.containsKey(root)) return lookup.get(root);
        int take = root.val;
        int notTake = 0;
        notTake = solve(root.left, lookup) + solve(root.right, lookup);

        if(root.left != null){
            take += (solve(root.left.left, lookup) + solve(root.left.right, lookup));
        }
        if(root.right != null){
            take += (solve(root.right.left, lookup) + solve(root.right.right, lookup));
        }

        int ans = Math.max(take, notTake);
        lookup.put(root, ans);
        return ans;
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> lookup = new HashMap<>();
        return solve(root, lookup);
    }
}