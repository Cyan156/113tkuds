class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q10_TreeComparison {

    // 1. 判斷兩樹是否相同
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    // 2. 判斷 t 是否為 s 的子樹
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3. 找最大公共子樹
    static class Result {
        int size;
        TreeNode node;
        Result(int size, TreeNode node) {
            this.size = size;
            this.node = node;
        }
    }

    public static TreeNode largestCommonSubtree(TreeNode a, TreeNode b) {
        Result res = helper(a, b);
        return res.node;
    }

    private static Result helper(TreeNode a, TreeNode b) {
        if (a == null || b == null) return new Result(0, null);

        Result leftRes = helper(a.left, b.left);
        Result rightRes = helper(a.right, b.righ
