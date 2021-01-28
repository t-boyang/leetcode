public class HammingWeight {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = (n - 1) & n;
        }
        return ans;
    }
}
