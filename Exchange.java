import java.util.Arrays;

public class Exchange {
    private int change(int[] nums) {
        int i = 0;
        int j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
        return i - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int right = this.change(nums);
        int left = 0;
        while (left < right) {
            if (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right && nums[left] % 2 != 0) {
                left++;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        if (left % 2 != 0) {
            left++;
        }
        int length = nums.length - 1;
        right = this.change(nums);
        while (length > right) {
            swap(nums, length, left);
            left++;
            length--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] result = new Exchange().exchange(new int[] { 0, 0, 1, 4, 2, 3, 5, 10, 18, 0, 14, 17, 29, 31, 35, 1 });
        System.out.println(Arrays.toString(result));
    }
}