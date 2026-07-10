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
    private TreeNode solve(int preorderStart, int preorderEnd, int inorderStart, 
    int inorderEnd, List<Integer> preorder, List<Integer> inorder){
        if(preorderStart > preorderEnd || inorderStart > inorderEnd) return null;
        
        TreeNode root = new TreeNode(preorder.get(preorderStart));
        int index = inorder.indexOf(preorder.get(preorderStart));
        int leftCount = index-inorderStart;
        int rightCount = inorderEnd-index;
        root.left = solve(preorderStart+1, preorderStart+leftCount, inorderStart, index-1, preorder, inorder);
        root.right = solve(preorderStart+leftCount+1, preorderEnd, index+1, inorderEnd, preorder, inorder);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = Arrays.stream(preorder).boxed().toList();
        List<Integer> inorderList = Arrays.stream(inorder).boxed().toList();

        int preorderStart = 0; int preorderEnd = preorder.length-1;
        int inorderStart = 0; int inorderEnd = inorder.length-1;
        return solve(preorderStart, preorderEnd, inorderStart,
         inorderEnd, preorderList, inorderList);
    }
}
