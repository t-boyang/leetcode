public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur <= 0) {
                cur = nums[i];
            } else {
                cur = cur + nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}
