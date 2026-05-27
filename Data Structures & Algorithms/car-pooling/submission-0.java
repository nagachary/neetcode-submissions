class Solution {
    private record Trip(int capacity, int startPoint, int endPoint) {
    }

    public boolean carPooling(int[][] trips, int capacity) {
        List<Trip> tripList = new ArrayList<>();
        for (int[] trip : trips) {
            tripList.add(new Trip(trip[0], trip[1], trip[2]));
        }
        tripList.sort(Comparator.comparingInt(t -> t.startPoint));
        PriorityQueue<Trip> tripPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.endPoint));
        int currentCapacity = 0;
        for (Trip trip : tripList) {
            //Existing Trip
            while (!tripPriorityQueue.isEmpty()
                    && tripPriorityQueue.peek().endPoint <= trip.startPoint) {
                currentCapacity = currentCapacity - tripPriorityQueue.poll().capacity;
            }
            //Next Trip
            currentCapacity = currentCapacity + trip.capacity;
            if (currentCapacity > capacity) {
                return false;
            }
            tripPriorityQueue.add(trip);
        }
        return true;
    }
}