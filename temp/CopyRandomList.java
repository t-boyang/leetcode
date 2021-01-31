package temp;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        createNode(head);
        createRandom(head);
        return spliteNode(head);
    }

    private void createNode(Node head) {
        Node p = head;
        while (p != null) {
            Node data = new Node(p.val);
            data.next = p.next;
            data.random = null;
            p.next = data;
            p = data.next;
        }
    }

    private void createRandom(Node head) {
        Node p = head;
        while (p != null) {
            Node data = p.next;
            if (p.random != null) {
                data.random = p.random.next;
            }
            p = data.next;
        }
    }

    private Node spliteNode(Node head) {
        Node cloneHead = null;
        Node pClone = null;
        Node p = head;
        if (p != null) {
            cloneHead = p.next;
            pClone = cloneHead;
            p.next=pClone.next;
            p = p.next;
        }
        while (p != null) {
            pClone.next = p.next;
            pClone = pClone.next;
            p.next = pClone.next;
            p = p.next;
        }
        return cloneHead;
    }
}
