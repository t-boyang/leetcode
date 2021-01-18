import java.lang.reflect.Array;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int length = 1;
        dp[0][0] = true;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (str[i] == str[j]) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] = true && (j - i + 1 > length)) {
                    length = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + length);
    }
}
