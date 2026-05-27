class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int[] array;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sumList = new ArrayList<>();
        array = nums;
        backTracking(target, sumList, 0);
        return result;
    }

    private void backTracking(int target, List<Integer> sumList, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(sumList));
        } else if(target < 0){
            return;
        } else {
            for (int i = idx; i < array.length; i++) {
                sumList.add(array[i]);
                backTracking(target-array[i], sumList, i);
                sumList.removeLast();
            }
        }
    }
}
