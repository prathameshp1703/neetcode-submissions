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
    private void solve(TreeNode root, PriorityQueue<Integer> kSmallestValues, int k){
        if(root == null) return;
        if(kSmallestValues.size()<k){
            kSmallestValues.add(root.val);
        }
        else if(kSmallestValues.peek() > root.val){
            kSmallestValues.poll();
            kSmallestValues.add(root.val);
        }
        solve(root.left, kSmallestValues, k);
        solve(root.right, kSmallestValues, k);

        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> kSmallestValues = new PriorityQueue<>((val1, val2)->{
            return Integer.compare(val2, val1);
        });

        solve(root, kSmallestValues, k);
        return kSmallestValues.peek();
    }
}
