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
        bfs(root, result);
        return result;
    }

    public void bfs(TreeNode root, List<Integer> result) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, Integer> tmp = new HashMap<>();

        if (root == null) {
            return;
        }

        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.right != null) {
                    q.add(node.right);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(!tmp.containsKey(level)){
                    tmp.put(level, node.val);
                    result.add(node.val);
                }
            }
            level++;
        }
    }
}