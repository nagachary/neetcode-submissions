class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target) {
                count = count + 1;
                minLen = Math.min(minLen, i - left + 1);
                sum = sum - nums[left];
                left++;

            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}