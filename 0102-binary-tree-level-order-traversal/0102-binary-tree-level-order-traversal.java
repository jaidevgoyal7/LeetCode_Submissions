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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        bfs(root, result, new ArrayList<>());
        return result;
    }

    public void bfs(TreeNode root, List<List<Integer>> result, List<Integer> current) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int q_len = q.size();
            for (int i = 0; i < q_len; i++) {
                TreeNode node = q.remove();
                if(node != null){
                    current.add(node.val);
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                }
            }
            if (!current.isEmpty()) {
                result.add(new ArrayList<>(current));
                current = new ArrayList<>();
            }
        }
    }
}