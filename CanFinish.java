import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegress = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] data : prerequisites) {
            indegress[data[0]]++;
            adj.get(data[1]).add(data[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int data : adj.get(course)) {
                indegress[data]--;
                if (indegress[data] == 0) {
                    queue.offer(data);
                }
            }
        }
        return numCourses == 0;
    }
}
