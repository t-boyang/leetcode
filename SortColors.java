import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        // [0,p0)==0
        // [p0,i)==1
        // (p2,len-1]==2
        int p0 = 0;
        int i = 0;
        int p2 = len - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                i++;
                p0++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] data = { 2, 0, 2, 1, 1, 0 };
        new SortColors().sortColors(data);
        System.out.println(Arrays.toString(data));
    }
}
