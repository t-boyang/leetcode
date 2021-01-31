package dp;
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = getMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        return dp[m][n];
    }

    private int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
