class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = nums1.length + nums2.length;
        int lowIdx = 0;
        int highIdx = nums1.length;

        while (lowIdx <= highIdx) {
            int m1 = (lowIdx + highIdx) / 2;
            int m2 = (totalLength + 1) / 2 - m1;

            int l1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
            int r1 = (m1 == nums1.length) ? Integer.MAX_VALUE : nums1[m1];
            int l2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
            int r2 = (m2 == nums2.length) ? Integer.MAX_VALUE : nums2[m2];

            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l2 > r1) {
                lowIdx = m1 + 1;
            } else {
                highIdx = m1 - 1;
            }

        }

        return 0.0;
         
    }
}
