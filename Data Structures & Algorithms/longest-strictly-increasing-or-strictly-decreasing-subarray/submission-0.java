class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count_incr = 1;
        int count_decr = 1;
        int i = 1;
        int max = 1;
            while (i < nums.length) {
                
                if (nums[i - 1] < nums[i]) {
                    count_incr++;
                } else {
                    count_incr = 1;
                }

                if (nums[i - 1] > nums[i]) {
                    count_decr++;
                } else {
                    count_decr = 1;
                }
                i++;
                max = Math.max(max, Math.max(count_incr, count_decr));
            }
        return max;   
    }
}