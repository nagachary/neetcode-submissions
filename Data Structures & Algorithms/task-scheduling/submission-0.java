class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Count frequencies using a HashMap
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // 2. Max Heap to always pick the most frequent task
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());

        int totalTime = 0;

        // 3. Process tasks in cycles
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int slotsInCycle = n + 1; // n+1 because, n tasks plus 1 idle (cooling) cycle.
            int tasksHandled = 0;

            // Try to fill the cycle with unique tasks
            while (slotsInCycle > 0 && !maxHeap.isEmpty()) {
                int currentMaxFreq = maxHeap.poll();
                if (currentMaxFreq > 1) {
                    tempList.add(currentMaxFreq - 1);
                }
                tasksHandled++;
                slotsInCycle--;
            }

            // Put tasks back into the heap for the next round
            maxHeap.addAll(tempList);

            // If heap is empty, we finished all tasks in this last round
            // Otherwise, we add the full cycle length (including idle time)
            if (maxHeap.isEmpty()) {
                totalTime += tasksHandled;
            } else {
                totalTime += (n + 1);
            }
        }

        return totalTime;
    }
}
