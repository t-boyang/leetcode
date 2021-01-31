package dp;
import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        int n = envelopes.length;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = envelopes[i][1];
        }
        return lengthOfLIS(data);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        int result=new MaxEnvelopes().maxEnvelopes(new int[][]
            {{5,4},{6,4},{6,7},{2,3}}
        );
        System.out.println(result);
    }
}
