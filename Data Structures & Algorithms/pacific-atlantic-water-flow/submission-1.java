class Solution {
     int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;

        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        int totalRows = heights.length;
        int totalCols = heights[0].length;

        //Adding first row and first column cell values to queue
        addRowToQueue(0, queue, totalCols);
        addColToQueue(0, queue, totalRows);

        boolean[][] pacificTable = bfs(queue, totalRows, totalCols);

        addRowToQueue(totalRows - 1, queue, totalCols);
        addColToQueue(totalCols - 1, queue, totalRows);

        boolean[][] atlanticTable = bfs(queue, totalRows, totalCols);

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (atlanticTable[i][j] == true && pacificTable[i][j] == true) {
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }

        return result;
    }

    private void addRowToQueue(int currentRow, Queue<int[]> queue, int totalCols) {
        for (int i = 0; i < totalCols; i++) {
            int currentCol = i;
            int[] currentCell = {currentRow, currentCol};
            queue.add(currentCell);
        }
    }

    private void addColToQueue(int currentCol, Queue<int[]> queue, int totalRows) {
        for (int i = 0; i < totalRows; i++) {
            int currentRow = i;
            int[] currentCell = {currentRow, currentCol};
            queue.add(currentCell);
        }
    }

    private boolean[][] bfs(Queue<int[]> queue, int totalRows, int totalCols) {

        boolean[][] visitedCells = new boolean[totalRows][totalCols];

        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();

            int currRow = currCell[0];
            int currCol = currCell[1];

            if (visitedCells[currRow][currCol]) {
                continue;
            }
            visitedCells[currRow][currCol] = true;

            int currentCellVal = heights[currRow][currCol];

            if (0 <= currRow - 1 && heights[currRow - 1][currCol] >= currentCellVal && !visitedCells[currRow - 1][currCol]) {
                queue.add(new int[]{currRow - 1, currCol});
            }

            if (0 <= currCol - 1 && heights[currRow][currCol - 1] >= currentCellVal && !visitedCells[currRow][currCol - 1]) {
                queue.add(new int[]{currRow, currCol - 1});
            }

            if (currCol + 1 < totalCols && heights[currRow][currCol + 1] >= currentCellVal && !visitedCells[currRow][currCol + 1]) {
                queue.add(new int[]{currRow, currCol + 1});
            }

            if (currRow + 1 < totalRows && heights[currRow + 1][currCol] >= currentCellVal && !visitedCells[currRow + 1][currCol]) {
                queue.add(new int[]{currRow + 1, currCol});
            }
        }

        return visitedCells;

    }
}
