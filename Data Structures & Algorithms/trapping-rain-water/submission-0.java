class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] maxOnLeftArray = new int[height.length];
        int[] maxOnRightArray = new int[height.length];

        maxOnLeftArray[0] = 0;
        int leftMaxHeight = 0;
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight = Math.max(height[i - 1], leftMaxHeight);
            maxOnLeftArray[i] = leftMaxHeight;
        }

        int rightIdx = size - 1;
        maxOnRightArray[rightIdx] = 0;
        int rightMaxHeight = 0;
        for (int i = rightIdx-1; i >= 0; i--) {
            rightMaxHeight = Math.max(height[i+1], rightMaxHeight);
            maxOnRightArray[i] = rightMaxHeight;

        }
        
        //LeftMax:  0 0 2 2 3 3 3 3 3 3
        //RightMax: 3 3 3 3 3 3 3 2 1 0
        //Min.    : 0 0 2 2 3 3 3 2 1 0
        //heights : 0 2 0 3 1 0 1 3 2 1
        //Water   : 0   2   2 3 2
        int[] waterArr = new int[size];
        for (int i = 0; i < size; i++) {
            waterArr[i] = Math.min(maxOnLeftArray[i], maxOnRightArray[i]) - height[i];
        }
        int totalWater = 0;
        for (int i = 0; i < size; i++) {
            if(waterArr[i] > 0) {
                totalWater = totalWater +  waterArr[i];
            }
        }
        return totalWater;
    }
}
