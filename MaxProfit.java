public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = { 7, 1, 5, 3, 6, 4 };
        System.out.println(new MaxProfit().maxProfit(data));
    }
}
