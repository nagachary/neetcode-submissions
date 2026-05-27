class Solution {
    final static int[][] four_directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Mark border-connected regions
        for (int r = 0; r < rows; r++) {
            dfsMark(board, r, 0);
            dfsMark(board, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            dfsMark(board, 0, c);
            dfsMark(board, rows - 1, c);
        }

        // Flip surrounded regions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    private void dfsMark(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return;

        if (board[r][c] != 'O') return;

        board[r][c] = 'T';

        for (int[] d : four_directions) {
            dfsMark(board, r + d[0], c + d[1]);
        }
    }

}
