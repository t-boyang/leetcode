import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyQueue {
    private LinkedList<Integer> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void push(int data) {
        while (!queue.isEmpty() && data > queue.getLast()) {
            queue.removeLast();
        }
        queue.addLast(data);
    }

    public void pop(int data) {
        if (queue.getFirst() == data) {
            queue.removeFirst();
        }
    }

    public int max() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.getFirst();
        }
    }
}

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k - 1; i++) {
            queue.push(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            queue.push(nums[i]);
            ans.add(queue.max());
            queue.pop(nums[i - k + 1]);
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
