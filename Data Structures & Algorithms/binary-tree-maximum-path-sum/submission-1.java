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
       int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        totalSum(root);
        return maxSum;
    }

    private int totalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(totalSum(root.left), 0);// Max sum of the left subtree
        int rightSum = Math.max(totalSum(root.right), 0); // Max sum of the right subtree

        int totalPathSum = root.val + leftSum + rightSum;// Sum of the total path including the max sum of the left + max sum of right + root node val

        maxSum = Math.max(maxSum, totalPathSum); // update the maxSum variable with maximum sum identified at the current node

        return root.val + Math.max(leftSum, rightSum);
    }
}
