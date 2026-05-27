class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length - n; i++) {
            list1.add(nums1[i]);
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        list1.addAll(list2);
        Collections.sort(list1);
        for (int i = 0; i < list1.size(); i++) {
            nums1[i] = list1.get(i);
        }
    }
}