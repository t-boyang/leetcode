public class Trap {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                if (height[i] > leftMax) {
                    leftMax = height[i];
                } else {
                    ans += leftMax - height[i];
                }
                i++;
            } else {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                } else {
                    ans += rightMax - height[j];
                }
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}
