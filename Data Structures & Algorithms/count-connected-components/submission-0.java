class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components_count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(adjacency_list, visited, i);
                components_count++;
            }

        }

        return components_count;
    }

    private void bfs(List<List<Integer>> adjacency_list, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.poll();
            for (int neighbor_edge : adjacency_list.get(current_node)) {
                if (!visited[neighbor_edge]) {
                    visited[neighbor_edge] = true;
                    queue.offer(neighbor_edge);
                }
            }
        }
    }
    
}
