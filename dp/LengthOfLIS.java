import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp, 1);
        int result=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            result=Math.max(result, dp[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{
            10,9,2,5,3,7,101,18
        }));
    }
}
