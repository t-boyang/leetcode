package temp;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class GetLeastNumbers {
    public int findKthLargest(int[] nums, int k) {
        int heapLength = nums.length;
        buildHeap(nums, heapLength);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapLength--;
            maxHeapify(nums, heapLength, 0);
        }
        return nums[0];
    }

    private void buildHeap(int[] arr, int heapLength) {
        for (int i = heapLength / 2; i >= 0; i--) {
            maxHeapify(arr, heapLength, i);
        }
    }

    private void maxHeapify(int[] arr, int heapLength, int i) {
        int pos = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < heapLength && arr[left] > arr[pos]) {
            pos = left;
        }
        if (right < heapLength && arr[right] > arr[pos]) {
            pos = right;
        }
        if (i != pos) {
            swap(arr, i, pos);
            maxHeapify(arr, heapLength, pos);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // public int[] getLeastNumbers(int[] arr, int k) {
    // quickSelect(arr, k, 0, arr.length - 1);
    // int[] ans = new int[k];
    // for (int i = 0; i < k; i++) {
    // ans[i] = arr[i];
    // }
    // return ans;
    // }

    // private int quickSelect(int[] arr, int k, int start, int end) {
    // if (start == end) {
    // return arr[start];
    // }
    // Random random = new Random();
    // int pivot_index = random.nextInt(end - start) + start;
    // pivot_index = partition(arr, start, end, pivot_index);
    // if (pivot_index < k) {
    // return quickSelect(arr, k, pivot_index + 1, end);
    // } else if (pivot_index > k) {
    // return quickSelect(arr, k, start, pivot_index - 1);
    // } else {
    // return arr[pivot_index];
    // }
    // }

    // private int partition(int[] arr, int start, int end, int pivot_index) {
    // int pivot = arr[pivot_index];
    // swap(arr, pivot_index, end);
    // int store_index = start;
    // for (int i = start; i < end; i++) {
    // if (arr[i] < pivot) {
    // swap(arr, i, store_index);
    // store_index++;
    // }
    // }
    // swap(arr, store_index, end);
    // return store_index;
    // }

    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
