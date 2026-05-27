class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int count = 0;
        int carsCount = position.length;
        //An array if cars with time taken to target position.
        double[][] carsAndTimeArray = new double[carsCount][2];

        for (int i = 0; i < carsCount; i++) {
            carsAndTimeArray[i][0] = position[i];
            carsAndTimeArray[i][1] = (double) (target - position[i]) / speed[i];
        }
        //Sort the cars by their position.
        Arrays.sort(carsAndTimeArray, (a, b) -> Double.compare(b[0], a[0]));
        double prevTimeToTarget = 0;

        for (double[] carsAndTime : carsAndTimeArray) {
            if (carsAndTime[1] > prevTimeToTarget) {
                count++;
                prevTimeToTarget = carsAndTime[1];
            }
        }
        return count;
    }
}
