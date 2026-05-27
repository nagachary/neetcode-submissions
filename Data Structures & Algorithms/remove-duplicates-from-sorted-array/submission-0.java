class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> uniqueList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
           if (!uniqueList.contains(nums[i])) {
               uniqueList.add(nums[i]);
           }
        }
        int i = 0;
        for (Integer ele : uniqueList) {
            nums[i] = ele;
            i++;
        }
        return uniqueList.size();
    }
}