class Solution {
    int[][] grid;
    int total_rows;
    int total_col;
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.total_rows = grid.length;
        this.total_col = grid[0].length;
        visited = new boolean[total_rows][total_col];

        for (int i = 0; i < total_rows; i++) {
            for (int j = 0; j < total_col; j++) {
                if (grid[i][j] == 1) {
                    return perimeter(i, j);
                }
            }
        }
        return 0;
    }

    private int perimeter(int i, int j) {
        if (i < 0 || i >= total_rows || j < 0 || j >= total_col || grid[i][j] == 0) {
            return 1;
        }

        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return perimeter(i - 1, j) + perimeter(i + 1, j) + perimeter(i, j - 1) + perimeter(i, j + 1);
    }
}