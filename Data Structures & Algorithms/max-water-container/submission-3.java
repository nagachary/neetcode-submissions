class Solution {
    public int maxArea(int[] height) {
         int size = height.length;
        if (size == 0 || size == 1) {
            return 0;
        }

        int left = 0;
        int right = size - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            int area = width * length;
            if (area > maxArea)
                maxArea = area;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
