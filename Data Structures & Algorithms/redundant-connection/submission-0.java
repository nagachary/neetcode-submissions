class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent_array = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            parent_array[i] = i; // each node is parent to itself.
        }

        for (int[] edge : edges) {
            int edgeNode1 = edge[0];
            int edgeNode2 = edge[1];

            int parent1 = findParent(parent_array, edgeNode1);
            int parent2 = findParent(parent_array, edgeNode2);

            if (parent1 == parent2) {
                return edge;
            }
            parent_array[parent2] = parent1;
        }
        return new int[0];
    }

    private int findParent(int[] parent_array, int edgeNode) {
        while (edgeNode != parent_array[edgeNode]) {
            parent_array[edgeNode] = parent_array[parent_array[edgeNode]];
            edgeNode = parent_array[edgeNode];
        }
        return edgeNode;
    }
}
