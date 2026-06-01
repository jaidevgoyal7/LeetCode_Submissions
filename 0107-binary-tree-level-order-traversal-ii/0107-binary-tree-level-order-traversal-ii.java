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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        bfs(root, result);

        return result;
    }

    public void bfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> current = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int q_size = q.size();

            for (int i = 0; i < q_size; i++) {
                TreeNode node = q.remove();
                current.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (!current.isEmpty()) {
                result.add(new ArrayList<>(current));
                current.clear();
            }
        }
        Collections.reverse(result);
    }
}