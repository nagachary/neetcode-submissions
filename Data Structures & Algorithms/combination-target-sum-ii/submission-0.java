class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int[] array;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        array = candidates;
        Arrays.sort(array);
        List<Integer> sumList = new ArrayList<>();
        backTrack(target, sumList, 0);
        return result;
    }

    private void backTrack(int target, List<Integer> sumList, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(sumList));
            return;
        }
        for (int i = index; i < array.length; i++) {
            if (i > index && array[i] == array[i - 1]) {
                continue;
            }
            if (target - array[i] < 0) {
                break;
            }
            sumList.add(array[i]);
            backTrack(target - array[i], sumList, i + 1);
            sumList.removeLast();
        }
    }
}
