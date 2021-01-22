import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node p = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        p.next = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (i == size - 1) {
                    p.next = null;
                } else {
                    p.next = queue.peek();
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        
    }
}
