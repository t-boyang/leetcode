public class StrStr {
    public int strStr(String haystack, String needle) {
        int s = haystack.length();
        int n = needle.length();
        for (int i = 0; i < s - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("aaaaa", "aba"));
    }
}
