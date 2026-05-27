class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Double> map = new HashMap<>();
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(points.length);
        int[] origin = {0, 0};
        for (int[] point : points) {
            Double sqrtVal = Math.sqrt((0 - point[0]) * (0 - point[0]) + (0 - point[1]) * (0 - point[1]));
            map.put(point, sqrtVal);
            priorityQueue.offer(sqrtVal);
        }

        int[][] resultArray = new int[k][2];
        int idx = 0;

        while (idx < k) {
            double minDist = priorityQueue.poll();

            // find ONE point with this distance
            Iterator<Map.Entry<int[], Double>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<int[], Double> entry = it.next();
                if (Double.compare(entry.getValue(), minDist) == 0) {
                    resultArray[idx++] = entry.getKey();
                    it.remove();
                    break;
                }
            }
        }
        return resultArray;
    }
}
