class Solution {
    public int minDistance(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();
        int dp[][] = new int[n + 1][m + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    // same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {// different
                    int add = dp[i][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;
                    int rep = dp[i - 1][j - 1] + 1;
                    // dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                    // Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = Math.min(add, Math.min(del, Math.min(rep, del)));
                }
            }
        }
        return dp[n][m];
    

    }
}