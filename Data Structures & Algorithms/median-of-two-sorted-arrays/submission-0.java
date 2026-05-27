class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       List<Integer> list1 = new ArrayList<>();

        for (int i : nums1) {
            list1.add(i);
        }

        for (int i : nums2) {
            list1.add(i);
        }

        Collections.sort(list1);

        int size = list1.size();
        int middle = size / 2;

        if (size % 2 == 0) {
            return (double) (list1.get(middle - 1) + list1.get(middle)) / 2;
        } else {
            return list1.get(middle);
        }
         
    }
}
