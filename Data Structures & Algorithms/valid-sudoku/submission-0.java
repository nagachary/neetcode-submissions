class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = 9;
        HashSet<Character>[] rows = new HashSet[size];
        HashSet<Character>[] cols = new HashSet[size];
        HashSet<Character>[] boxes = new HashSet[size];

        for (int i = 0; i < size; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char val = board[row][col];

                if (val == '.') {
                    continue;
                }

                if (rows[row].contains(val)) {
                    return false;
                }
                rows[row].add(val);

                if (cols[col].contains(val)) {
                    return false;
                }
                cols[col].add(val);

                int boxIdx = (row / 3) * 3 + col / 3;
                if (boxes[boxIdx].contains(val)) {
                    return false;
                }
                boxes[boxIdx].add(val);

            }

        }

        return true;
    }
}
