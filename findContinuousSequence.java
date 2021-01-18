import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result=new ArrayList<>();
        for(int i=1,j=2;i<j;){
            int sum=(i+j)*(j-i+1)/2;
            if(sum==target){
                int[] res=new int[j-i+1];
                for(int k=i;k<j;k++){
                    res[k-i]=k;
                }
                result.add(res);
                i++;
            }  else if(sum<target){
                j++;
            } else {
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        
    }
}
