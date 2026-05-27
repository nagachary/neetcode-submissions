class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[nums.length];

        int prefixProd = 1;
        res[0] = prefixProd;
        for (int i = 1; i < size; i++) {
            prefixProd = prefixProd * nums[i-1];
            res[i] = prefixProd;
        }

        int suffixProd = 1;
        for (int i = size-1; i > -1; i--) {
            res[i] = res[i] * suffixProd;
            suffixProd = suffixProd* nums[i];
        }
        return res;
    }
}  
