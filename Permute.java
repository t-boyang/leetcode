import java.util.ArrayList;
import java.util.List;

public class Permute {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        for (int i : nums) {
            path.add(i);
        }
        backTrace(0, path);
        return result;
    }

    private void backTrace(int pos, List<Integer> path) {
        if (pos == path.size()) {
            result.add(new ArrayList<>(path));
        }
        for (int i = pos; i < path.size(); i++) {
            swap(path, i, pos);
            backTrace(pos + 1, path);
            swap(path, i, pos);
        }
    }

    private void swap(List<Integer> data, int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Permute().permute(new int[] { 1, 2, 3 });
        System.out.println(result.toString());
    }
}
