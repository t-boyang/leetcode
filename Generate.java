import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(1);
            for (int j = 1; j < i; j++) {
                path.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i != 0) {
                path.add(1);
            }
            result.add(path);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
    }
}
