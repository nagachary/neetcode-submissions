class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println("countMap :" + countMap);

        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        for (int ele : countMap.keySet()) {
            minHeap.add(ele);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        
        return res;
        
    }
}
