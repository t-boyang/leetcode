public class MajorityElement {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                cur = nums[i];
            }
            if (nums[i] == cur) {
                vote++;
            } else {
                vote--;
            }
        }
        return cur;
    }
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{
            2,2,1,1,1,2,2
        }));
    }
}
