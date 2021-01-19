public class MyPow {
    public double myPow(double x, int n) {
        long n1 = n;
        if (n1 == 0) {
            return 1.0;
        }
        if (n1 < 0) {
            n1 = -n1;
            x = 1 / x;
        }
        double res = 1.0;
        while (n1 != 0) {
            if (n1 % 2 == 1) {
                res *= x;
            }
            x = x * x;
            n1 /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.1, 3));
    }
}
