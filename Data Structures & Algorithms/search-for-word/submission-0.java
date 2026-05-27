class Solution {
    int no_of_rows;
    int no_of_cols;
    char[][] arrays;
    public boolean exist(char[][] board, String word) {
        this.arrays = board;
        this.no_of_rows = board.length;
        this.no_of_cols = board[0].length;

        for (int i = 0; i < no_of_rows; i++) {
            for (int j = 0; j < no_of_cols; j++) {
                if (backtrack(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean backtrack(int i, int j, String word, int charIndex) {
        if (charIndex >= word.length()) {
            return true;
        }
        if (i < 0 || i >= no_of_rows || j < 0 || j >= no_of_cols || this.arrays[i][j] != word.charAt(charIndex)) {
            return false;
        }
        this.arrays[i][j] = '#';
        boolean result = false;
        for (int[] direction : directions) {
            result =  backtrack(i + direction[0], j + direction[1], word, charIndex + 1);
            if(result) {
                break;
            }
        }
        this.arrays[i][j] = word.charAt(charIndex);
        return result;
    }
}
