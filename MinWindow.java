import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        char[] t1 = t.toCharArray();
        char[] s1 = s.toCharArray();
        for (char d : t1) {
            need.put(d, need.getOrDefault(d, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        int value = 0;
        while (right < s.length()) {
            char c = s1[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).compareTo(need.get(c)) == 0) {
                    value++;
                }
            }
            while (value == need.size()) {
                if (length > right - left) {
                    length = right - left;
                    start = left;
                }
                char d = s1[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).compareTo(need.get(d)) == 0) {
                        value--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }
}
