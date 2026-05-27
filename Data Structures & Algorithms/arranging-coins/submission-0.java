class Solution {
    public int arrangeCoins(int n) {
        int com = 0;
        for (int i = 1; i <= n; i++) {
            n = n-i;
            com = i;
        }
        return com;
    }
}