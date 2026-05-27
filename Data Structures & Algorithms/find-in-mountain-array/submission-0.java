/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        // 1. Find the Peak (Maximum Value) Index
        int start = 0, end = length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int peak = start;

        // 2. Search Left Side (Ascending)
        int res = binarySearch(mountainArr, target, 0, peak, true);
        if (res != -1) return res;

        // 3. Search Right Side (Descending)
        return binarySearch(mountainArr, target, peak + 1, length - 1, false);
    }

    private static int binarySearch(MountainArray arr, int target, int lowIdx, int highIdx, boolean isAscending) {
        while (lowIdx <= highIdx) {
            int mid = lowIdx + (highIdx - lowIdx) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;

            if (isAscending) {
                if (val < target) {
                    lowIdx = mid + 1;
                } else {
                    highIdx = mid - 1;
                }
            } else {
                if (val > target) {
                    lowIdx = mid + 1;
                } else {
                    highIdx = mid - 1;
                }
            }
        }
        return -1;
    }
}