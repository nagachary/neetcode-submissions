class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            int j = i + 1;
            while (j < arr.length) {
                max = Math.max(max, arr[j]);
                j++;
            }
            arr[i] = max;
        }
        return arr;
    }
}