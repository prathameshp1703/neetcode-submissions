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

public class Codec {

    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return ;
        }
        sb.append(String.valueOf(root.val)).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private TreeNode deserializeHelper(Queue<String> curr){
        String frontNode = curr.poll();
        TreeNode root = frontNode.equals("null") ? null : new TreeNode(Integer.valueOf(frontNode));
        if(root == null) return root;
        root.left = deserializeHelper(curr);
        root.right = deserializeHelper(curr);
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> curr = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(curr);
        
    }
}
