import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            path = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode data = queue.poll();
                path.add(data.val);
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
        System.out.println(new LevelOrder().levelOrder(root));
    }
}
