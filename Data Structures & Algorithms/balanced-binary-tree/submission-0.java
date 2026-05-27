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
        if (root == null) {
            return true;
        } else {
        
        //Determine the height of left subtree of root node
       int leftSubTreeHeight = heightOfTheBinaryTree(root.left);
        //Determine the height of right subtree of root node
       int righSubTreeHeight = heightOfTheBinaryTree(root.right);

       //Determine the left and right subtree height difference and determine the left and right subtrees are balanced.
        return Math.abs(leftSubTreeHeight - righSubTreeHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    //Determine the max height at each node which is a root node.
    public int heightOfTheBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            //Determine the max height at each node which is a root node.
            return 1 + Math.max(heightOfTheBinaryTree(root.left), heightOfTheBinaryTree(root.right));
        }
    }
}
