import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int left = getLeftPos(nums, target);
        int right = getRightPos(nums, target);
        return new int[] { left, right };
    }

    private int getLeftPos(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start > nums.length - 1 || nums[start] != target) {
            return -1;
        } else {
            return start;
        }
    }

    private int getRightPos(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] == target) {
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (end < 0 || nums[end] != target) {
            return -1;
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
    }
}
