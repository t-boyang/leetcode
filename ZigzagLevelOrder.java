import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> path = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            path = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode data = queue.poll();
                if (result.size() % 2 == 0) {
                    path.addLast(data.val);
                } else {
                    path.addFirst(data.val);
                }
                if (data.left != null) {
                    queue.offer(data.left);
                }
                if (data.right != null) {
                    queue.offer(data.right);
                }
            }
            result.add(path);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }
}
