public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (next == null) {
                newHead = p;
            }
            p.next = pre;
            pre = p;
            p = next;
        }
        return newHead;
    }
}
