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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return createLeftAndRightNodes(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);
    }

    private TreeNode createLeftAndRightNodes(int[] preorder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int leftIndex, int rightIndex) {

        TreeNode rootNode = new TreeNode(preorder[rootIndex]);

        int midIndex = inOrderIndexMap.get(preorder[rootIndex]);

        if (midIndex > leftIndex) {

            rootNode.left = createLeftAndRightNodes(preorder, inOrderIndexMap, rootIndex + 1, leftIndex, midIndex - 1);
        }
        if (midIndex < rightIndex) {
            rootNode.right = createLeftAndRightNodes(preorder, inOrderIndexMap, rootIndex + 1 + midIndex - leftIndex, midIndex + 1, rightIndex);
        }

        return rootNode;
    }

}
