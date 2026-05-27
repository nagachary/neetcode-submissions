class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int maxElement = Integer.MIN_VALUE;
        for (int bananaPile : piles) {
            maxElement = Math.max(bananaPile, maxElement);
        }

        int leftElement = 1;
        int rightElement = maxElement;
        
        while (leftElement < rightElement) {
            int midEle = leftElement + (rightElement - leftElement) / 2;

            int calculatedEatingHrs = 0;
            for (int i = 0; i < piles.length; i++) {
                int noOfHrs = (int) Math.ceil((double)piles[i] / midEle);
                calculatedEatingHrs = calculatedEatingHrs + noOfHrs;
            }

            if (calculatedEatingHrs <= h) {
                rightElement = midEle;
            } else {
                leftElement = midEle + 1;
            }
        }
        return leftElement;
    }
}
