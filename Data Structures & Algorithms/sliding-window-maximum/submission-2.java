class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if (nums.length == 1 || k == 1 ) {
            return nums;
        }

        int length = nums.length;
        int[] intArr = new int[length - k + 1];

        for (int i = 0; i < length; i++) {
            int max = 0;
            int leftIdx = i;
            int rightIdx = leftIdx + k - 1;
            while (leftIdx <= rightIdx && rightIdx < length) {
                int currentVal = nums[leftIdx];
                max = Math.max(max, currentVal);
                leftIdx++;
            }
            if (i < length - k + 1) {
                intArr[i] = max;
            }

        }
        return intArr;
    }
}
