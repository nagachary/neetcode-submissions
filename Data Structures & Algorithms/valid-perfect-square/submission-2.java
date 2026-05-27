class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        long half = num / 2;
        while (half >= 1) {
            long sqr = half * half;
            if (sqr == num) {
                return true;
            }
            half = half - 1;
        }
        return false;
    }
}