class Solution {
    public int largestRectangleArea(int[] heights) {
     int maxArea = 0;
        int n = heights.length;
        int[] leftSmallerNearest = new int[n];
        int[] rightSmallerNearest = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightSmallerNearest[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmallerNearest[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int width = rightSmallerNearest[i] - leftSmallerNearest[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
