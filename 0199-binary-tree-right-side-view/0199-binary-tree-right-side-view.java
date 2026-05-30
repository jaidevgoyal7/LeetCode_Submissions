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
        List<Integer> result = new ArrayList<>();
        int depth = 0;
        dfs(root, depth, result);
        return result;
    }

    public void dfs(TreeNode root, int depth, List<Integer> result){
        if(root == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }
        dfs(root.right, depth+1, result);
        dfs(root.left, depth+1, result);
    }
}