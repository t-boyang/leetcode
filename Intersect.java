import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Intersect {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix.length - 1];
        while (start < end) {
            int mid = (start + end) >> 1;
            if (this.check(matrix, mid) <= k) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public int check(int[][] matrix, int mid) {
        int n = matrix.length;
        int i = 0;
        int j = n - 1;
        int num = 0;
        while (i <= n - 1 && j >= 0) {
            if (matrix[i][j] <= mid) {
                num += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return num;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[Math.min(m, n)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans[k] = nums1[i];
                i++;
                k++;
                j++;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);
    }
    

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        Random random = new Random();
        int pivot_index = random.nextInt(end - start) + start;
        pivot_index = partion(nums, start, end, pivot_index);
        if (k < pivot_index) {
            return quickSelect(nums, k, start, pivot_index - 1);
        } else if (k > pivot_index) {
            return quickSelect(nums, k, pivot_index + 1, end);
        } else {
            return nums[pivot_index];
        }
    }

    private int partion(int[] data, int left, int right, int pivot_index) {
        int pivot = data[pivot_index];
        swap(data, pivot_index, right);
        int store_index = left;
        for (int i = left; i < right; i++) {
            if (data[i] < pivot) {
                swap(data, i, store_index);
                store_index++;
            }
        }
        swap(data, store_index, right);
        return store_index;
    }

    private void swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        // System.out.println(new Intersect().getSum(3, 5));
        // int[] a={1,2,2,1};
        // int[] b={2,2};
        // System.out.println(Arrays.toString(new Intersect().intersect(a, b)));
    }
}
