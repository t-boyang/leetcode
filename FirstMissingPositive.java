import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int data : nums) {
            set.add(data);
        }
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
    }
}
