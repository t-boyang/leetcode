import java.util.Arrays;

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

    public static void main(String[] args) {
        System.out.println(new Intersect().getSum(3, 5));
        // int[] a={1,2,2,1};
        // int[] b={2,2};
        // System.out.println(Arrays.toString(new Intersect().intersect(a, b)));
    }
}
