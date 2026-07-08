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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> currNodes = new LinkedList<>();
        currNodes.add(root);

        while(currNodes.size()>0){
            int size = currNodes.size();
            Integer lastNode = -1;
            for(int i=0; i<size; i++){
                TreeNode frontNode = currNodes.peek();
                currNodes.poll();
                if(frontNode.left != null){
                    currNodes.add(frontNode.left);
                }
                if(frontNode.right != null){
                    currNodes.add(frontNode.right);
                }
                lastNode = frontNode.val;
            }
            ans.add(lastNode);
        }

        return ans;
    }
}
