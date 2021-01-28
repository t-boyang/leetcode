class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class HasCycle {
    // private int parttion(int[] data,int left, int right, int pivot_index) {
    //     int pivot=data[pivot_index];
    //     swap(data,pivot_index,right);
    //     int store_index=left;
    //     for(int i=left;i<=right;i++){
    //         if(data[i]<pivot){
    //             swap(data,i,store_index);
    //             store_index++;
    //         }
    //     }
    //     swap(data,right,store_index);
    //     return store_index;
    // }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
