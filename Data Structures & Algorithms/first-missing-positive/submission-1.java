class Solution {
    public int firstMissingPositive(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && !integerList.contains(nums[i])) {
                integerList.add(nums[i]);
            }
        }
        Collections.sort(integerList);
        if (integerList.isEmpty() || integerList.get(0) != 1) {
            return 1;
        }
        
        int minIdx = -1;
        int j = integerList.get(0);
        for (int i = 0; i < integerList.size(); i++) {
            if (j != integerList.get(i)) {
                minIdx = i;
                break;
            }
            j++;
        }
        if (minIdx == -1) {
            return j;
        }
        return integerList.get(minIdx - 1) + 1;
    }
}