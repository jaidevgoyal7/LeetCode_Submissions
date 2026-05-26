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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result){
        if(root == null){
            return;
        }
        
        current.add(root.val);
        if(targetSum == root.val && root.left == null && root.right == null){
            result.add(new ArrayList<>(current));
        }
        dfs(root.left, targetSum - root.val, current, result);
        dfs(root.right, targetSum - root.val, current, result);
        current.remove(current.size() - 1);
    }
}