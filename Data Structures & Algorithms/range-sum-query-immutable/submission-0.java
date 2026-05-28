class NumArray {
 int[] nums;
    public NumArray(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    public int sumRange(int left, int right) {
        int totalSum = 0;

        for (int i = left; i <= right; i++) {
            totalSum = totalSum + nums[i];
        }

        return totalSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */