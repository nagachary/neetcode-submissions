class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       for (int i = 0; i < matrix.length; i++) {
            int leftIdx = 0;
            int rightIdx = matrix[i].length - 1;
            while (leftIdx <= rightIdx) {
                int midIx = leftIdx + (rightIdx - leftIdx) / 2;

                if (matrix[i][midIx] == target) {
                    return true;
                } else if (matrix[i][midIx] < target) {
                    leftIdx = midIx + 1;
                } else {
                    rightIdx = midIx - 1;
                }
            }
        }
        return false; 
    }
}
