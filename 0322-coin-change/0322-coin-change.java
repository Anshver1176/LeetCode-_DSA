class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // amount 0 needs 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // No coins available
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                // Don't take coin
                dp[i][j] = dp[i - 1][j];

                // Take coin
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        1 + dp[i][j - coins[i - 1]]
                    );
                }
            }
        }

        if (dp[n][amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return dp[n][amount];
    }
}