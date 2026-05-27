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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNode3Queue = new LinkedList<>();
        treeNode3Queue.add(root);

        while (!treeNode3Queue.isEmpty()) {
            int size = treeNode3Queue.size();
            List<Integer> currentLevelNodesList = new ArrayList<>();

            while (size-- > 0) {
                TreeNode currentNode = treeNode3Queue.poll();
                currentLevelNodesList.add(currentNode.val);
                if (currentNode.left != null) treeNode3Queue.offer(currentNode.left);
                if (currentNode.right != null) treeNode3Queue.offer(currentNode.right);
            }
            result.add(currentLevelNodesList);
        }
        return result;
    }
}
