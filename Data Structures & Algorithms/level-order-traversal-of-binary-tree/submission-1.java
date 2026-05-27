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
    List<List<Integer>> levelOrderResult;
    public List<List<Integer>> levelOrder(TreeNode root) {
         levelOrderResult = new ArrayList<>();
        if (root == null) return levelOrderResult;
        traverseLevel(root, 0);
        return levelOrderResult;
    }

    private void traverseLevel(TreeNode node, int level) {
        if(node == null) return;

        if(levelOrderResult.size() == level) {
            levelOrderResult.add(new ArrayList<>());
        }
        levelOrderResult.get(level).add(node.val);
        traverseLevel(node.left, level+1);
        traverseLevel(node.right, level+1);

    }
}
