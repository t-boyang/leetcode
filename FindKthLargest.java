import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int heapLength = nums.length;
        buildHeap(nums, heapLength);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapLength--;
            maxHeapify(nums, 0, heapLength);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums, int heapLength) {
        for (int i = heapLength / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapLength);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapLength) {
        int pos = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < heapLength && nums[left] > nums[pos]) {
            pos = left;
        }
        if (right < heapLength && nums[right] > nums[pos]) {
            pos = right;
        }
        if (pos != i) {
            swap(nums, pos, i);
            maxHeapify(nums, pos, heapLength);
        }
    }
    // public int findKthLargest(int[] nums, int k) {
    // Queue<Integer> queue=new PriorityQueue<>();
    // for(int i=0;i<nums.length;i++){
    // if(queue.size()<k){
    // queue.offer(nums[i]);
    // } else if(nums[i]>queue.peek()){
    // queue.poll();
    // queue.offer(nums[i]);
    // }
    // }
    // return queue.peek();
    // }
    // public int findKthLargest(int[] nums, int k) {
    // if (nums.length == 0) {
    // return 0;
    // }
    // return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    // }

    // private int quickSelect(int[] nums, int start, int end, int k) {
    // if (start == end) {
    // return nums[start];
    // }
    // Random random = new Random();
    // int pivot_index = random.nextInt(end - start) + start;
    // pivot_index = partition(nums, start, end, pivot_index);
    // if (pivot_index == k) {
    // return nums[pivot_index];
    // } else if (pivot_index > k) {
    // return quickSelect(nums, start, pivot_index - 1, k);
    // } else {
    // return quickSelect(nums, pivot_index + 1, end, k);
    // }
    // }

    // private int partition(int[] nums, int left, int right, int pivot_index) {
    // int pivot = nums[pivot_index];
    // int store_index = left;
    // swap(nums, pivot_index, right);
    // for (int i = left; i < right; i++) {
    // if (nums[i] < pivot) {
    // swap(nums, i, store_index);
    // store_index++;
    // }
    // }
    // swap(nums, store_index, right);
    // return store_index;
    // }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
