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
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null ){
            return null;
        }

        q.add(root);

        while(!q.isEmpty()){
            for(int i = 0; i < q.size(); i++){
                TreeNode node = q.remove();
                if(node.val == val){
                    return node;
                }
                if(node.val > val && node.left != null){
                    q.add(node.left);
                }else if(node.val < val && node.right != null){
                    q.add(node.right);
                }
            }
        }
        return null;
    }
}