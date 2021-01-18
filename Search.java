public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
                if (nums[mid] <= target & target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] >= nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[] { 1, 3 }, 2));
    }
}
