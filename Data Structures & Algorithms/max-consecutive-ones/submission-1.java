class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(nums[i]);
            count = Math.max(count, stringBuilder.length());
        }
        return count;
    }
}