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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        backtrack("", root, result);
        return result;
    }

    public void backtrack(String current, TreeNode root, List<String> result){
        if(root == null){
            return;
        }
        if(current.isEmpty()){
            current = String.valueOf(root.val);
        }else{
            current += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(current);
            return;
        }

        backtrack(current, root.left, result);

        backtrack(current, root.right, result);
    }
}