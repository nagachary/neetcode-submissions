class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int noOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    traverseNeighborsUsingDFS(grid, i, j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private void traverseNeighborsUsingDFS(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        traverseNeighborsUsingDFS(grid, i + 1, j);
        traverseNeighborsUsingDFS(grid, i - 1, j);
        traverseNeighborsUsingDFS(grid, i, j + 1);
        traverseNeighborsUsingDFS(grid, i, j - 1);
    }
}
