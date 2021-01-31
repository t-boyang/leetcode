public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        int i=0;
        int j=columns-1;
        while(i<rows&&j>=0){
            if(matrix[i][j]<target){
                i++;
            } else if (matrix[i][j]>target){
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
