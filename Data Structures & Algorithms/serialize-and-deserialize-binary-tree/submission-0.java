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

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while(curr.size()>0){
            TreeNode front = curr.poll();
            if(sb.length()>0){
                sb.append(",");
            }
            if(front == null){
                sb.append("null");
            }
            else{
                sb.append(String.valueOf(front.val));
            }
            if(front!=null){
                curr.add(front.left);
            }
            if(front!=null){
                curr.add(front.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String [] nodes = data.split(",");
        
        int size = nodes.length-1;
        Queue<TreeNode> curr = new LinkedList<>();
        while(size >= 0){
            String node = nodes[size];
            if(node.equals("null")){
                curr.add(new TreeNode((int)-1e9));
            }
            else{
                TreeNode temp = new TreeNode(Integer.valueOf(node));
                TreeNode front1 = curr.poll();
                TreeNode front2 = curr.poll();
                temp.right = (front1.val == -1e9) ? null :  front1;
                temp.left = (front2.val == -1e9) ? null :  front2;
                curr.add(temp);
            }
            size--;
        }
        return curr.poll();
    }
}
