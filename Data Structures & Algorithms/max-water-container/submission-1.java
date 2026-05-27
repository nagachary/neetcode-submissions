class Solution {
    public int maxArea(int[] heights) {
        int size = heights.length;
        if (size == 0 || size == 1) {
            return 0;
        }

        int left = 0;
        int right = size - 1;
        int maxArea = 0;
        while (left < right) {
           int area = (right - left) * Math.min(heights[right], heights[left]);
            maxArea = Math.max(area, maxArea);
            if (left == right - 1) {
                right--;
                left = 0;
            }
            left++;
        }
        return maxArea;
    }
}
