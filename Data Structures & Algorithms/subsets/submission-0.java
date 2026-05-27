class Solution {
    List<List<Integer>> resultSet = new LinkedList<>();
    int[] array;

    public List<List<Integer>> subsets(int[] nums) {
        array = nums;
        dfs(new LinkedList<>(), 0);
        return resultSet;
    }

    private void dfs(List<Integer> subSet, int index) {
        resultSet.add(new ArrayList<>(subSet));
        for (int i = index; i < array.length; i++) {
            subSet.add(array[i]);
            dfs(subSet, i + 1);
            subSet.removeLast();
        }
    }
}
