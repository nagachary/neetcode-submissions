class Solution {
    List<List<Integer>> resultSet = new LinkedList<>();
    int[] array;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        array = nums;
        Arrays.sort(array);
        dfs(new LinkedList<Integer>(), 0);
        return resultSet;
    }

    private void dfs(List<Integer> subSet, int index) {
        resultSet.add(new ArrayList<>(subSet));
        for (int i = index; i < array.length; i++) {
            if (i != index && array[i] == array[i - 1]) {
                continue;
            }
            subSet.add(array[i]);
            dfs(subSet, i + 1);
            subSet.removeLast();
        }
    }
}
