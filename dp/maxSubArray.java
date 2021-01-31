package dp;
public class maxSubArray {
    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < nums.length; i++) {
            if (cur <= 0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
