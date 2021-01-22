public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int data : nums) {
            res ^= data;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[] { 4, 2, 1, 2, 1 }));
    }
}
