public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTCore(nums, start, mid - 1);
        root.right = sortedArrayToBSTCore(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new SortedArrayToBST().sortedArrayToBST(new int[]{
            -10,-3,0,5,9
        });
        System.out.println(new LevelOrder().levelOrder(node));
    }
}
