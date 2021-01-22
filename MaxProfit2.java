public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = { 7, 1, 5, 3, 6, 4 };
        System.out.println(new MaxProfit2().maxProfit(data));
    }
}
