public class MySqrt {
    public int mySqrt(int x) {
        int mid = 0;
        int left = 0, right = x;
        while (left <= right) {
            mid = (left + right) >> 1;
            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int val = new MySqrt().mySqrt(4);
        System.out.println(val);
    }
}
