class Solution {
     List<List<Integer>> result = new LinkedList<>();
    int[] array;

    public List<List<Integer>> combine(int n, int k) {
        array = new int[n];
        int v = 1;
        for (int i = 0; i < n; i++) {
            array[i] = v;
            v++;
        }
        List<Integer> subList = new ArrayList<>();
        backTrack(subList, 0, k);
        return result;
    }

    private void backTrack(List<Integer> subList, int idx, int k) {
        if (subList.size() == k) {
            result.add(new ArrayList<>(subList));
            return;
        }
        for (int i = idx; i < array.length; i++) {
            subList.add(array[i]);
            backTrack(subList, i + 1, k);
            subList.removeLast();
        }
    }
}