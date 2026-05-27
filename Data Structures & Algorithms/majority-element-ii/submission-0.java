class Solution {
     public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        int limit = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            if (entries.getValue() > limit) {
                list.add(entries.getKey());
            }
        }
        return list;
    }
}