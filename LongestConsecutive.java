import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int data : nums) {
            set.add(data);
        }
        int max = 1;
        for (int data : set) {
            int cur = 0;
            if (!set.contains(data - 1)) {
                cur = 1;
                while (set.contains(data + cur)) {
                    cur++;
                }
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
    }
}
