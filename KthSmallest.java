class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int num = check(matrix, mid, k, n);
            if (num >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int check(int[][] matrix, int mid, int k, int n) {
        int i = 0;
        int j = n - 1;
        int num = 0;
        while (i < n && j >= 0) {
            if (matrix[i][j] <= mid) {
                num += j + 1;
                if(matrix[i][j]==mid){
                    break;
                }
                i++;
            } else {
                j--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] data = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        new KthSmallest().kthSmallest(data, 8);
    }
}