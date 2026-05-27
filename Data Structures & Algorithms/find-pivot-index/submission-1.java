class Solution {
    public int pivotIndex(int[] nums) {
     int leftSum = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum = totalSum + num;
        }
        
        for (int currentIdx = 0; currentIdx < nums.length; currentIdx++) {
            int rightSum = totalSum - leftSum - nums[currentIdx];
            if (leftSum == rightSum) {
                return currentIdx;
            }
            leftSum = leftSum + nums[currentIdx];
        }
        return -1;
    }
}