import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductExceptSelf {
    // [1,2,3,4]
    // [24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] ans = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4 };
        int[] ans = new ProductExceptSelf().productExceptSelf(data);
        System.out.println(Arrays.toString(ans));
    }
}
