import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import jdk.internal.net.http.hpack.QuickHuffman;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(right) + 1);
            }
            max = Math.max(max, right - left + 1);
            map.put(s.charAt(right), right);
        }
        return max;
    }

    public int majorityElement(int[] nums) {
        int vote = 0;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                vote++;
            } else {
                vote--;
            }
            if (vote == 0) {
                result = nums[i];
            }
        }
        return result;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
