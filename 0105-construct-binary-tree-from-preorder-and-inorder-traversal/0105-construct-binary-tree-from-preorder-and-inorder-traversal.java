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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }
        return buildTreeUsingHashMap(preorder, mp, 0, preorder.length - 1);
    }

    public TreeNode buildTreeUsingHashMap(int[] preorder, Map<Integer,Integer> mp,int left, int right){
        if(left > right){
            return null;
        }
        int val = preorder[preIndex];
        preIndex++;
        TreeNode node = new TreeNode(val);

        int index = mp.get(val);

        node.left = buildTreeUsingHashMap(preorder, mp, left, index - 1);
        node.right = buildTreeUsingHashMap(preorder, mp, index + 1, right);

        return node;
    }
}