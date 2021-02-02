public class isPalindromes {
    // medium
    // reverse
    // compare
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode q = reverse(slow);
        slow.next = null;
        slow = head;
        while (slow != null && q != null) {
            if (q.val != slow.val) {
                return false;
            }
            q = q.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode pre = null;
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

    public static void main(String[] args) {
        ListNode p = new ListNode(0);
        p.next = new ListNode(0);
        new isPalindromes().isPalindrome(p);
    }
}
