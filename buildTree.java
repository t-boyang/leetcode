import java.util.HashMap;
import java.util.Map;

public class buildTree {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return buildTreeCore(0, 0, preorder.length - 1);
    }

    private TreeNode buildTreeCore(int rootPos, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootPos]);
        int i = map.get(preorder[rootPos]);
        root.left = buildTreeCore(rootPos + 1, left, i - 1);
        root.right = buildTreeCore(rootPos + i - left + 1, i + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode node = new buildTree().buildTree(preorder, inorder);
        System.out.println(new LevelOrder().levelOrder(node));
    }
}
