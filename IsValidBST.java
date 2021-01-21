import java.util.Stack;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        double val = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= val) {
                return false;
            }
            val = root.val;
            root = root.right;
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new IsValidBST().isValidBST(root));
    }
}
