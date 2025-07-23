import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q6_BSTValidation {

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> invalid = new ArrayList<>();
        findInvalid(root, null, null, invalid);
        return invalid;
    }

    private static void findInvalid(TreeNode node, Integer min, Integer max, List<Integer> invalid) {
        if (node == null) return;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            invalid.add(node.val);
        }
        findInvalid(node.left, min, node.val, invalid);
        findInvalid(node.right, node.val, max, invalid);
    }

    public static int minNodesToRemove(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        collectInOrder(root, inorder);
        return inorder.size() - longestIncreasingSubsequence(inorder);
    }

    private static void collectInOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        collectInOrder(node.left, list);
        list.add(node.val);
        collectInOrder(node.right, list);
    }

    private static int longestIncreasingSubsequence(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(dp, num);
            if (i < 0) i = -(i + 1);
            if (i == dp.size()) dp.add(num);
            else dp.set(i, num);
        }
        return dp.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); // 不合法，應該大於10
        root.left.left = new TreeNode(2);
        root.left
