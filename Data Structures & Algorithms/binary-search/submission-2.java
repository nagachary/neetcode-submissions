class Solution {
    public int search(int[] nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            int midIx = leftIdx + (rightIdx - leftIdx) / 2;

            if (nums[midIx] == target) {
                return midIx;
            } else if (nums[midIx] < target) {
                leftIdx = midIx + 1;
            } else {
                rightIdx = midIx - 1;
            }
        }
        return -1;
    }
}
