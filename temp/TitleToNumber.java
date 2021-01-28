public class TitleToNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            ans = ans * 26 + (str[i] - 'A' + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
