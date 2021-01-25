public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0;
        int length = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 >= length) {
                    start = i;
                    length = j - i + 1;
                }
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
}