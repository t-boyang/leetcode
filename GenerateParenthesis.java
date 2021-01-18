import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        dfs("", 0, 0, 0, n);
        return result;
    }

    private void dfs(String path, int pos, int left, int right, int sum) {
        if (pos == 2 * sum) {
            result.add(new String(path));
        }
        if (left < sum) {
            dfs(path + "(", pos + 1, left + 1, right, sum);
        }
        if (right < left) {
            dfs(path + ")", pos + 1, left, right + 1, sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}