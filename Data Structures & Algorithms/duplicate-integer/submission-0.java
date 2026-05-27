class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> intList = new ArrayList<>();
        for(int n : nums) {
            if(!intList.contains(n)) {
                intList.add(n);
            } else {
                return true;
            }
        }
        return false;
    }
}