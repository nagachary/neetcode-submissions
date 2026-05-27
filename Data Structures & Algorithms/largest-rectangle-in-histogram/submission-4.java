class Solution {
    public int largestRectangleArea(int[] heights) {
    int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int maxArea = 0;

        int[] leftIdxArr = new int[n];
        int[] rightIdxArr = new int[n];
        leftIdxArr[0] = -1;
        rightIdxArr[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = leftIdxArr[prev];
            }
            leftIdxArr[i] = prev;
        }

        for (int i = n - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < n && heights[next] >= heights[i]) {
                next = rightIdxArr[next];
            }
            rightIdxArr[i] = next;
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (rightIdxArr[i] - leftIdxArr[i] - 1)));

        }

        return maxArea;
    }
}
