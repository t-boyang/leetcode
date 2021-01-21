import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] data = intervals[i];
            int left = data[0];
            int right = data[1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                if (intervals[i + 1][1] >= right) {
                    right = intervals[i + 1][1];
                }
                i++;
            }
            result.add(new int[] { left, right });
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] data = new int[][] { { 1, 4 }, { 2, 3 } };
        int[][] result = new Merge().merge(data);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.err.println();
        }
    }
}
