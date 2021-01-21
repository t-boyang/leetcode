import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        backTrace(nums, new ArrayList<>(), 0);
        return result;
    }

    private void backTrace(int[] nums, ArrayList<Integer> path, int pos) {
        result.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[] { 1, 2, 3 }));
    }
}
