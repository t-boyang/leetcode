public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left=left.next;
            } else {
                p.next = right;
                right=right.next;
            }
            p = p.next;
        }
        if (left != null) {
            p.next = left;
        } else {
            p.next = right;
        }
        return dummy.next;
    }
}
