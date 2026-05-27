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
               int length  = (right - left);
               int width = Math.min(height[right], height[left]);
               int area = length * width;
                maxArea = Math.max(area, maxArea);

                if (left == right - 1) {
                    right--;
                    left = 0;
                } else {
                    left++;
                }

            }
            return maxArea;
    }
}
