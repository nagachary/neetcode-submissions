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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewNodeList = new ArrayList<>();
        List<List<Integer>> listOfList = new ArrayList<>();
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> currentLeveList = new ArrayList<>();

            while (size > 0) {
                TreeNode currentNode = nodeQueue.poll();
                currentLeveList.add(currentNode.val);
                if (currentNode.left != null) nodeQueue.offer(currentNode.left);
                if (currentNode.right != null) nodeQueue.offer(currentNode.right);
                size--;
            }
            listOfList.add(currentLeveList);
        }

        for (List<Integer> list : listOfList) {
            rightViewNodeList.add(list.get(list.size() - 1));
        }
        return rightViewNodeList;
    }
}
