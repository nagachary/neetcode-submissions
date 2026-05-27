class Solution {
    public int maxAscendingSum(int[] nums) {
       int i = 1;
        int maxSum = nums[0];
        int currentSum = nums[0];
        while (i < nums.length) {

            if (nums[i - 1] < nums[i]) {
                System.out.println("nums[i - 1]  : " + nums[i - 1] + "nums[i] : " + nums[i]);
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }
            i++;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;  
    }
}