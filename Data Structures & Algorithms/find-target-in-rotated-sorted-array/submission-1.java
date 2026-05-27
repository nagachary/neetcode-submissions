class Solution {
    public int search(int[] nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if (nums[midIdx] == target) {
                return midIdx;
            }
            if (nums[leftIdx] <= nums[midIdx]) { //left sorted scenario

                if (nums[leftIdx] <= target && target <= nums[midIdx]) {
                    rightIdx = midIdx - 1;
                } else {
                    leftIdx = midIdx + 1;
                }

            } else { // right sorted
                if (nums[midIdx] <= target && target <= nums[rightIdx]) {
                    leftIdx = midIdx + 1;
                } else {
                    rightIdx = midIdx -1;
                }
            }
        }
        return -1;
    }
}
