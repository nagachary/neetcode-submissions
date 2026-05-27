class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int blankSpaces = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftIsOk = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightIsOk = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                if (leftIsOk && rightIsOk) {
                    blankSpaces++;
                    flowerbed[i] = 1;
                }
            }
        }
        return blankSpaces >= n;
    }
}