import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : nums) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> data : map.entrySet()) {
            int key = data.getKey();
            int value = data.getValue();
            priorityQueue.offer(new int[] { key, value });
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}
