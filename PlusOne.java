import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                carry = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            } else {
                int val = digits[i] + carry; // !
                digits[i] = (val) % 10;
                carry = (val) / 10;
            }
            if (carry == 0) {
                break;
            }
        }
        if (carry != 0) {
            int[] newData = new int[digits.length + 1];
            newData[0] = carry;
            for (int i = 1; i < digits.length; i++) {
                newData[i] = digits[i - 1];
            }
            return newData;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[] { 8, 9, 9, 9 })));
    }
}
