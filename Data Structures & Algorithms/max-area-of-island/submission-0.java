class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, traverseNeighborsUsingDFS(grid, i, j));
                }
            }

        }
        return maxArea;
    }

    private int traverseNeighborsUsingDFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int area = grid[i][j];
        grid[i][j] = 0;
        
        return area + traverseNeighborsUsingDFS(grid, i + 1, j) + traverseNeighborsUsingDFS(grid, i - 1, j)
                + traverseNeighborsUsingDFS(grid, i, j + 1) + traverseNeighborsUsingDFS(grid, i, j - 1);
    }
}
