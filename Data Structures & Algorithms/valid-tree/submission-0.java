class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        //since the given edges are un-directed
        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : adjacency_list.get(node)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                stack.push(neighbor);
                visited.add(neighbor);
            }
        }

        if (visited.size() == n) {
            return true;
        }
        return false;
    }
}
