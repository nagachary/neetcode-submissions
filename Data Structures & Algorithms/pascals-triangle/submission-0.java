class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            output.add(addElement(output, i));
        }
        return output;
    }

    private List<Integer> addElement(List<List<Integer>> output, int idx) {
        if (idx == 1) {
            return List.of(1);
        }
        if (idx == 2) {
            return List.of(1, 1);
        }
        List<Integer> prev = output.get(idx - 2); // previous row
        List<Integer> curr = new ArrayList<>();

        curr.add(1);
        for (int i = 1; i < prev.size(); i++) {
            curr.add(prev.get(i - 1) + prev.get(i));
        }
        curr.add(1);
        return curr;
    }
}