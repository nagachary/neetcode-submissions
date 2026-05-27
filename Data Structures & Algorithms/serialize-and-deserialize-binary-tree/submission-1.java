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

        return serializeNodes(root, "");
    }

    private String serializeNodes(TreeNode root, String str) {

        if (root == null) {
            str = str + "NULL,";
        } else {
            str = str + root.val + ",";
            str = serializeNodes(root.left, str);
            str = serializeNodes(root.right, str);
        }
        
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] stringArray = data.split(",");
        List<String> list = Arrays.asList(stringArray);

        return buildTree(list);
    }

    int idx = -1;

    private TreeNode buildTree(List<String> list) {
        idx++;
        if (list == null || list.isEmpty() || "NULL".equalsIgnoreCase(list.get(idx).trim())) {
            return null;
        }

        TreeNode rootNode = new TreeNode(Integer.parseInt(list.get(idx).trim()));
        rootNode.left = buildTree(list);
        rootNode.right = buildTree(list);

        return rootNode;
    }
}
