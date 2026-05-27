class Solution {
    int[] array;
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        array = nums;
        boolean[] visited = new boolean[nums.length];
        backTrack(new LinkedList<Integer>(), visited);
        return result;
    }

    private void backTrack(List<Integer> current_permutation, boolean[] visited) {
        if (current_permutation.size() == array.length) {
            result.add(new ArrayList<>(current_permutation));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                current_permutation.add(array[i]);
                visited[i] = true;
                backTrack(current_permutation, visited);
                visited[i] = false;
                current_permutation.removeLast();
            }
        }
    }
}
