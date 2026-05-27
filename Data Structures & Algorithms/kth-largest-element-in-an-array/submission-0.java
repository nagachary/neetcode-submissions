class Solution {
    private PriorityQueue<Integer> minHeap;
    public int findKthLargest(int[] nums, int k) {
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {

            if (minHeap.size() == k) {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            } else {
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }
}
