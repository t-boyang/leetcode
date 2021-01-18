import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    private Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        recur(digits, "");
        return result;
    }

    private void recur(String digits, String path) {
        if (digits.length() == 0) {
            result.add(path);
            return;
        }
        char ch = digits.charAt(0);
        String str = map.get(ch);
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            recur(digits.substring(1), path + cur);
        }
    }
}
