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
    public boolean isValidBST(TreeNode root) {
        long maxAllowed = Long.MAX_VALUE;
        long minAllowed = Long.MIN_VALUE;
        return dfs(root, maxAllowed, minAllowed);
    }

    public boolean dfs(TreeNode root, long maxAllowed, long minAllowed) {
        if (root == null) {
            return true;
        }
        if (root.val <= minAllowed || root.val >= maxAllowed) {
            return false;
        }
        return dfs(root.left, root.val, minAllowed) && dfs(root.right, maxAllowed, root.val);
    }
}