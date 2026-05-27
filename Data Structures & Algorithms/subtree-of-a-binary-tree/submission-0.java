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

    private static String preOrderTraversal(TreeNode node) {
        if(node == null) {
            return "NULL";
        }

        String string = "" + node.val +
                preOrderTraversal(node.left) +
                preOrderTraversal(node.right);

        return string;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String fullTree = preOrderTraversal(root);
        String subTree = preOrderTraversal(subRoot);

        return fullTree.contains(subTree);
    }
}
