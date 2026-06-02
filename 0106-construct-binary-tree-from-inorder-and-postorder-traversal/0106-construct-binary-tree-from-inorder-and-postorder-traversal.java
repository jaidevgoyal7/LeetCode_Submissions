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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] postIndex = {postorder.length - 1};

        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }
        return buildTreeUsingHashMap(mp, postorder, postIndex, 0, postorder.length - 1);
    }

    public TreeNode buildTreeUsingHashMap(Map<Integer, Integer> mp, int[] postorder, int[] postIndex, int left, int right){
        if(left > right){
            return null;
        }
        int val = postorder[postIndex[0]];
        postIndex[0]--;
        TreeNode node = new TreeNode(val);
        int index = mp.get(val);

        node.right = buildTreeUsingHashMap(mp, postorder, postIndex, index + 1, right);
        node.left = buildTreeUsingHashMap(mp, postorder, postIndex, left,index - 1);

        return node;
    }
}