import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {
    public boolean isValids(String s) {
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                char value = map.get(str[i]);
                char stackValue = stack.empty() ? '#' : stack.pop();
                if (value != stackValue) {
                    return false;
                }
            } else {
                stack.push(str[i]);
            }
        }
        return stack.empty();
    }
}
