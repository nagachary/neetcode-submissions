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
    public boolean isBalanced(TreeNode root) {
      if(root == null) return true;
        return (heightBottomUpApproach(root) != -1);
    }

    //Determine left height, right height and the balance factor
    //If the balance factor is greater than 1 return -1 which means tree is not a balanced tree
    public static int heightBottomUpApproach(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = heightBottomUpApproach(node.left);
        int rightHeight = heightBottomUpApproach(node.right);
        int balanceFactor = Math.abs(leftHeight-rightHeight);

        if(balanceFactor > 1 || leftHeight == -1 || rightHeight == -1) return -1;
        return  1 + Math.max(leftHeight, rightHeight);
    }
}
