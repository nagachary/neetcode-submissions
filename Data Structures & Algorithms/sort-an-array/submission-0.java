class Solution {
    public int[] sortArray(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);

        for (int i = 0; i < numsList.size(); i++) {
            nums[i] = numsList.get(i);
        }
        return nums;
    }
}