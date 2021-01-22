import java.util.ArrayList;
import java.util.List;

public class Partition {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        backTrace(s, path);
        return ans;
    }

    private void backTrace(String s, List<String> path) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isSub(sub)) {
                path.add(sub);
                backTrace(s.substring(i, s.length()), path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isSub(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Partition().partition("aab"));
    }
}
