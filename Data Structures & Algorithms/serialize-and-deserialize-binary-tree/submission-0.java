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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuffer sbr = new StringBuffer();
        sbr = serializeNodes(root, sbr);
        sbr = sbr.deleteCharAt(sbr.lastIndexOf(","));
        return sbr.toString();
    }

    private StringBuffer serializeNodes(TreeNode root, StringBuffer sbr) {

        if (root == null) {
            sbr.append("NULL, ");
            return sbr;
        } else {
            sbr.append(root.val + ", ");
        }

        serializeNodes(root.left, sbr);
        serializeNodes(root.right, sbr);

        return sbr;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        StringTokenizer tokenizer = new StringTokenizer(data, ",");
        List<Integer> list = new ArrayList<>();

        while (tokenizer.countTokens() != 0 && tokenizer.hasMoreTokens()) {
            String nextToken = tokenizer.nextToken().trim();
            list.add(!"NULL".equalsIgnoreCase(nextToken) ? Integer.parseInt(nextToken) : null);
        }

        return buildTree(list);
    }

    int idx = -1;
    private TreeNode buildTree(List<Integer> list) {
        idx++;
        if (list == null || list.isEmpty() || list.get(idx) == null) {
            return null;
        }

        TreeNode rootNode = new TreeNode(list.get(idx));
        rootNode.left = buildTree(list);
        rootNode.right = buildTree(list);

        return rootNode;
    }
}
