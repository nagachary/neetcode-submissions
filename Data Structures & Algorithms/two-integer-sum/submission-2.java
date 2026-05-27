class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> balanceNumberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer balanceNumIdx = balanceNumberMap.get(nums[i]);
            if (balanceNumIdx != null) {
                return new int[]{balanceNumIdx, i};
            }
            Integer balanceNumber = target - nums[i];
            balanceNumberMap.put(balanceNumber, i);
        }
        return nums;
    }
}
