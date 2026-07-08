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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while(curr.size()>0){
            List<Integer> currLevelNodes = new ArrayList<>();
            int size = curr.size();
            for(int i=0; i<size; i++){
                TreeNode frontNode = curr.peek();
                curr.poll();
                if(frontNode.left != null){
                    curr.add(frontNode.left);
                }
                if(frontNode.right != null){
                    curr.add(frontNode.right);
                }
                currLevelNodes.add(frontNode.val);
            }
            ans.add(currLevelNodes);
        }

        return ans;
    }
}
