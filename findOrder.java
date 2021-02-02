import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findOrder {
    public int[] findOrders(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
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
        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans[i] = course;
            i++;
            numCourses--;
            for (int data : adj.get(course)) {
                indegress[data]--;
                if (indegress[data] == 0) {
                    queue.offer(data);
                }
            }
        }
        if (numCourses == 0) {
            return ans;
        } else {
            return new int[0];
        }
    }
}
