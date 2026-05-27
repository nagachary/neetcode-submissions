class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> setList = new HashSet<>();
        if (nums == null || nums.length == 1 || nums.length == 2) {
            return new ArrayList<>(new ArrayList<>());
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    int total = a + b + c;
                    if (total == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        setList.add(list);
                    }
                }

            }
        }
        return new ArrayList<>(setList);
    }
}
