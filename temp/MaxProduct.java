package temp;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int tMax=max;
            int tMin=min;
            max=getMax(nums[i], nums[i]*tMax, nums[i]*tMin);
            min=getMax(nums[i], nums[i]*tMax, nums[i]*tMin);
            ans=Math.max(max, ans);
        }
        return Math.max(max, ans);
    }

    private int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
