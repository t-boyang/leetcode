import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode data = queue.poll();
                if (data.left != null) {
                    queue.offer(data.left);
                }
                if (data.right != null) {
                    queue.offer(data.right);
                }
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
