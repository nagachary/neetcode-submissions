class Solution {
    public int[] productExceptSelf(int[] nums) {
         int size = nums.length;
        int[] res = new int[nums.length];
        int[] prefixArr;
        int[] suffixArr;
        for (int i = 0; i < size; i++) {
            prefixArr = Arrays.copyOfRange(nums, 0, i);
            suffixArr = Arrays.copyOfRange(nums, i + 1, size);
            res[i] = prod(prefixArr) * prod(suffixArr);
        }
        return res;
    }

    private static int prod(int[] array) {
        int prod = 1;
        for (int i = 0; i < array.length; i++) {
            prod = prod * array[i];
        }
        return prod;
    }
}  
