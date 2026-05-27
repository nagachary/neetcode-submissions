class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backTrack(board, 0, result);
        return result;
    }

    private void backTrack(char[][] board, int row, List<List<String>> result) {
        if (board.length == row) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValidCellPosition(board, row, col)) {
                board[row][col] = 'Q';
                backTrack(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValidCellPosition(char[][] board, int r, int c) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> resultedBoard = new ArrayList<>();
        for (char[] row : board) {
            resultedBoard.add(new String(row));
        }
        return resultedBoard;
    }
}
