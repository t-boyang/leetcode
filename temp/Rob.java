package temp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int left = robCore(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int right = robCore(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(left, right);
    }

    public int robCore(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob3(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        int left = rob3(root.left);
        int right = rob3(root.right);
        int val = left + right;
        int nextLeft = 0;
        if (root.left != null) {
            nextLeft = rob3(root.left.left) + rob3(root.left.right);
        }
        int nextRight = 0;
        if (root.right != null) {
            nextRight = rob3(root.right.left) + rob3(root.right.right);
        }
        int nextVal = nextLeft + nextRight;
        int result = Math.max(nextVal + root.val, val);
        map.put(root, result);
        return result;
    }
}
