class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            priorityQueue.offer(point);
        }
        int[][] resultArray = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] ele = priorityQueue.poll();
            System.out.println("ele : " + ele);
            resultArray[i] = ele;
        }
        return resultArray;
    }
}
