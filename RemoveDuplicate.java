public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        for (; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicate().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }
}
