class Solution {
    public int coinChange(int[] coins, int amount) {
        int max_val = amount + 1;
        int[] min_coins = new int[max_val];
        Arrays.fill(min_coins, max_val);

        min_coins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    min_coins[i] = Math.min(min_coins[i], min_coins[i - coins[j]] + 1);
                }
            }
        }

        if (min_coins[amount] < max_val) {
            return min_coins[amount];
        }

        return -1;
    }
}
