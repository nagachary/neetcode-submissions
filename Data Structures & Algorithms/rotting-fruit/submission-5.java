class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> vertexQueue = new LinkedList<>();
        int noOfFreshFruits = 0;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    noOfFreshFruits++;
                }
                if (grid[i][j] == 2) {
                    vertexQueue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (noOfFreshFruits > 0 && !vertexQueue.isEmpty()) {

            int length = vertexQueue.size();

            for (int i = 0; i < length; i++) {

                int[] currentVertex = vertexQueue.poll();
                int currRow = currentVertex[0];
                int currCol = currentVertex[1];

                for (int[] direction : directions) {
                    int nextRow = currRow + direction[0];
                    int nextCol = currCol + direction[1];

                    if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        vertexQueue.add(new int[]{nextRow, nextCol});
                        noOfFreshFruits--;
                    }
                }
            }
            count++;
        }
        return noOfFreshFruits == 0 ? count : -1;
    }
}
