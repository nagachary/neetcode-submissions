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

    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    private TreeInfo buildTreeInfo(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = buildTreeInfo(root.left);
        TreeInfo rightTreeInfo = buildTreeInfo(root.right);
        int heightAtaNode = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;

        int leftTreeDiameter = leftTreeInfo.diameter;
        int rightTreeDiameter = rightTreeInfo.diameter;
        int diameterThroughRoot = leftTreeInfo.height + rightTreeInfo.height;

        int diameterAtaNode = Math.max(Math.max(leftTreeDiameter, rightTreeDiameter), diameterThroughRoot);

        return new TreeInfo(heightAtaNode, diameterAtaNode);
    }

    public int diameterOfBinaryTree(TreeNode root) {
         return buildTreeInfo(root).diameter;
    }
}
