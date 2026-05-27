class Solution {
     public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificTable = new boolean[m][n];
        boolean[][] atlanticTable = new boolean[m][n];

        for (int col = 0; col < n; col++) {
            dfs(0, col, pacificTable, heights);
            dfs(m - 1, col, atlanticTable, heights);
        }

        for (int row = 0; row < m; row++) {
            dfs(row, 0, pacificTable, heights);
            dfs(row, n - 1, atlanticTable, heights);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacificTable[r][c] && atlanticTable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] heights) {
        visited[row][col] = true;
        final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow >= 0
                    && nextRow < heights.length
                    && nextCol >= 0
                    && nextCol < heights[0].length && !visited[nextRow][nextCol]
                    && heights[nextRow][nextCol] >= heights[row][col]) {

                dfs(nextRow, nextCol, visited, heights);
            }
        }
    }
}
