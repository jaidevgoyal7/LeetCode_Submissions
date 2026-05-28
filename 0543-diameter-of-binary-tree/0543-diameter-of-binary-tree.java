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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return diameter;
    }
    public int dfs(TreeNode root) {

        // Height of null node
        if (root == null) {
            return 0;
        }

        // Get left subtree height
        int left = dfs(root.left);

        // Get right subtree height
        int right = dfs(root.right);

        // Diameter passing through current node
        diameter = Math.max(diameter, left + right);

        // Return current subtree height
        return Math.max(left, right) + 1;
    }
}