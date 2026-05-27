class Solution {
    public int pivotIndex(int[] nums) {
     int leftSum = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum = totalSum + num;
        }
        System.out.println("totalSum : " + totalSum);

        for (int currentIdx = 0; currentIdx < nums.length; currentIdx++) {
            int nextId = currentIdx + 1;
            int rightSum = 0;
            while (nextId < nums.length) {
                rightSum = rightSum + nums[nextId];
                nextId++;
            }

            leftSum = totalSum - rightSum - nums[currentIdx];
            if (leftSum == rightSum) {
                return currentIdx;
            }
        }

        return -1;   
    }
}