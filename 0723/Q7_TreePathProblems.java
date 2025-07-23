import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q7_TreePathProblems {

    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsPaths(root, path, result);
        return result;
    }

    private static void dfsPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) result.add(new ArrayList<>(path));
        else {
            dfsPaths(node.left, path, result);
            dfsPaths(node.right, path, result);
        }
        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == target;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }

    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        maxPathDfs(root, 0, new ArrayList<>(), result, new int[]{Integer.MIN_VALUE});
        return result;
    }

    private static void maxPathDfs(TreeNode node, int sum, List<Integer> path, List<Integer> result, int[] maxSum) {
        if (node == null) return;
        sum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                result.clear();
                result.addAll(path);
            }
        } else {
            maxPathDfs(node.left, sum, path, result, maxSum);
            maxPathDfs(node.right, sum, path, result, maxSum);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        List<List<Integer>> paths = allRootToLeafPaths(root);
        for (List<Integer> path : paths) System.out.println(path);

        System.out.println(hasPathSum(root, 22));
        System.out.println(maxPathSum(root));
    }
}
