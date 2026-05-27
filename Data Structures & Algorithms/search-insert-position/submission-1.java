class Solution {
     public int searchInsert(int[] nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (nums[midIdx] == target) {
                return midIdx;
            } else if (nums[midIdx] < target) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }
        return leftIdx;
    }
}