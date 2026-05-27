class Solution {
    public void sortColors(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }
}