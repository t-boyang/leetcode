public class isMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, i, p, j - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                } else {
                    if (isMatch(s, i, p, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - i) == '.') {
            return true;
        }
        return s.charAt(i - 1) == s.charAt(j - 1);
    }
}
