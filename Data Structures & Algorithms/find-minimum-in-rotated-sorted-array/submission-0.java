class Solution {
    public int findMin(int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx < rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if (nums[midIdx] < nums[rightIdx]) {
                rightIdx = midIdx;
            } else {
                leftIdx = midIdx + 1;
            }
        }
        return nums[leftIdx];
    }
}
