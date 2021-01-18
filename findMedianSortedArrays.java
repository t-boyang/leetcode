public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int total = (m + n + 1) / 2;
        int i = 0;
        int j = m;
        while (i < j) {
            int nums1_mid = (i + j + 1) / 2;
            int nums2_mid = total - nums1_mid;
            if (nums1[nums1_mid - 1] > nums2[nums2_mid]) {
                j = nums1_mid - 1;
            } else {
                i = nums1_mid;
            }
        }
        int nums1_mid = i;
        int nums2_mid = total - nums1_mid;
        int n1_left = nums1_mid == 0 ? Integer.MIN_VALUE : nums1[nums1_mid - 1];
        int n1_right = nums1_mid == m ? Integer.MAX_VALUE : nums1[nums1_mid];
        int n2_left = nums2_mid == 0 ? Integer.MIN_VALUE : nums2[nums2_mid - 1];
        int n2_right = nums2_mid == n ? Integer.MAX_VALUE : nums1[nums2_mid];
        if ((m + n) % 2 == 1) {
            return (double) Math.max(n1_left, n2_left);
        } else {
            return (double) (Math.max(n1_left, n2_left) + Math.min(n1_right, n2_right)) / 2;
        }
    }
}
