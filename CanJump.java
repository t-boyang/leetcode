public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > res) {
                return false;
            }
            res = Math.max(res, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[] { 3, 2, 1, 0, 4 }));
    }
}
