/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Map<Node, Node> nodeMap = new HashMap<>();

        stack.push(node);
        nodeMap.put(node, new Node(node.val));

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node neighbor : curr.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val));
                    stack.push(neighbor);
                }
                nodeMap.get(curr).neighbors.add(nodeMap.get(neighbor));
            }
        }
        return nodeMap.get(node);
    }
}