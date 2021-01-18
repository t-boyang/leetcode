public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return devideListNode(lists, 0, lists.length - 1);
    }

    private ListNode devideListNode(ListNode[] list, int start, int end) {
        if (start >= end) {
            return list[start];
        }
        int mid = (start + end) >> 1;
        ListNode a = devideListNode(list, start, mid);
        ListNode b = devideListNode(list, mid + 1, end);
        return mergeListNode(a, b);
    }

    private ListNode mergeListNode(ListNode aHead, ListNode bHead) {
        if (aHead == null && bHead == null) {
            return null;
        }
        if (aHead == null) {
            return bHead;
        }
        if (bHead == null) {
            return aHead;
        }
        ListNode node = null;
        if (aHead.val <= bHead.val) {
            node = new ListNode(aHead.val);
            node.next = mergeListNode(aHead.next, bHead);
        } else {
            node = new ListNode(bHead.val);
            node.next = mergeListNode(aHead, bHead.next);
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        ListNode[] lists = new ListNode[] { a, b, c };
        ListNode result = new MergeKLists().mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
