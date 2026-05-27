class Solution {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int size = nums.length;
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() > size / 2) {
                return entrySet.getKey();
            }
        }
        return -1;
    }
}