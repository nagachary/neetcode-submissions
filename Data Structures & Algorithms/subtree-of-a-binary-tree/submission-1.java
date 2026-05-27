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

    private static boolean isSameTree(TreeNode rootTreeNode, TreeNode subTreeNode) {
        if(rootTreeNode == null && subTreeNode == null) {
            return true;
        }

        if(rootTreeNode == null || subTreeNode == null) {
            return false;
        }

        if(rootTreeNode.val != subTreeNode.val) {
            return false;
        }


        return isSameTree(rootTreeNode.left, subTreeNode.left) && isSameTree(rootTreeNode.right, subTreeNode.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) {
            return false;
        }

        if(isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
