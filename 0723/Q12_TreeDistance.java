import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q12_TreeDistance {

    // 1. 計算任意兩節點距離 (路徑長度: 節點數-1)
    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        TreeNode lca = lowestCommonAncestor(root, val1, val2);
        if (lca == null) return -1;
        int d1 = distanceFromNode(lca, val1, 0);
        int d2 = distanceFromNode(lca, val2, 0);
        if (d1 == -1 || d2 == -1) return -1;
        return d1 + d2;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private static int distanceFromNode(TreeNode node, int val, int dist) {
        if (node == null) return -1;
        if (node.val == val) return dist;
        int left = distanceFromNode(node.left, val, dist + 1);
        if (left != -1) retur
