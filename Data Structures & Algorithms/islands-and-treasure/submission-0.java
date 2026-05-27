class Solution {
    private record VertexPair(int startVertex, int endVertex) {
    }

    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<VertexPair> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0)
                    queue.add(new VertexPair(i, j));
            }
        }

        if (queue.isEmpty()) {
            return;
        }

        int[][] dirs = {{-1, 0}, {0, -1},
                {1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            VertexPair current = queue.poll();
            int currRow = current.startVertex;
            int currCol = current.endVertex;

            for (int[] direction : dirs) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];

                if (nextRow >= row || nextCol >= col || nextRow < 0 ||
                        nextCol < 0 || grid[nextRow][nextCol] != 2147483647) {
                    continue;
                }
                queue.add(new VertexPair(nextRow, nextCol));
                grid[nextRow][nextCol] = grid[currRow][currCol] + 1;
            }
        }
    }
}
