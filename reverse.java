public class reverse {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int y = 0;
        while (x != 0) {
            if (y / 10 > Integer.MAX_VALUE) {
                return -1;
            }
            if (y / 10 < Integer.MIN_VALUE) {
                return -1;
            }
            if (y / 10 == Integer.MAX_VALUE && (x % 10) > 7) {
                return -1;
            }
            if (y / 10 == Integer.MIN_VALUE && (x % 10) < -8) {
                return -1;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
