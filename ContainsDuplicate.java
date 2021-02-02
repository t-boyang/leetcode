import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int data : nums) {
            if (set.contains(data)) {
                return true;
            }
            set.add(data);
        }
        return false;
    }
}
