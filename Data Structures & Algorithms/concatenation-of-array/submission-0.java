class Solution {
    public int[] getConcatenation(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }

        int result_length = 2 * nums.length;
        int[] result = new int[result_length];

        for (int i = 0; i < result_length; i++) {
            result[i] = (i > nums.length - 1) ? nums[i - nums.length] : nums[i];
        }

        return result;
    }
}