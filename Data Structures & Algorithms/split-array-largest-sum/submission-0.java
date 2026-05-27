class Solution {
    public int splitArray(int[] nums, int k) {
        int maxVal = 0;
        long sumVal = 0;

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            sumVal += num;
        }

        long low = maxVal;
        long high = sumVal;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean canSplit(int[] nums, int k, long maxSum) {
        int currentSum = 0;
        int subarraysUsed = 1;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarraysUsed++;
                currentSum = num;

                if (subarraysUsed > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}