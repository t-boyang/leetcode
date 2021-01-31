package temp;
class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int data:nums){
            res^=data;
        }
        return res;
    }
}