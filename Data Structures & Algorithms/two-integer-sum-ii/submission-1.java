class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int left = 1;
        int right = numbers.length;
        while (left < right) {
            int sum = numbers[left - 1] + numbers[right - 1];

            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }

            if (sum == target) {
                return new int[]{left, right};
            }
        }
        return numbers;
    }
}
