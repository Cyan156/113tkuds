import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q11_BSTBalance {

    static class BalanceInfo {
        boolean balanced;
        int height;
        int maxUnbalanceNodeVal;
        int maxUnbalance;

        BalanceInfo(boolean balanced, int height, int maxUnbalanceNodeVal, int maxUnbalance) {
            this.balanced = balanced;
            this.height = height;
            this.maxUnbalanceNodeVal = maxUnbalanceNodeVal;
            this.maxUnbalance = maxUnbalance;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root).balanced;
    }

    // 回傳節點平衡資訊
    private static BalanceInfo checkBalance(TreeNode node) {
        if (node == null) return new BalanceInfo(true, 0, -1, 0);

        BalanceInfo left = checkBalance(node.left);
        BalanceInfo right = checkBalance(node.right);

        int height = Math.max(left.height, right.height) + 1;
        int balanceFactor = left.height - right.height;
        boolean balanced = left.balanced && right.balanced && Math.abs(balanceFactor) <= 1;

        int maxUnbalanceNodeVal = node.val;
        int maxUnbalance = Math.abs(balanceFactor);

        // 找最大不平衡節點
        if (left.maxUnbalance > maxUnbalance) {
            maxUnbalance = left.maxUnbalance;
            maxUnbalanceNodeVal = left.maxUnbalanceNodeVal;
        }
        if (right.maxUnbalance > maxUnbalance) {
            maxUnbalance = right.maxUnbalance;
            maxUnbalanceNodeVal = right.maxUnbalanceNodeVal;
        }

        return new BalanceInfo(balanced, height, maxUnbalanceNodeVal, maxUnbalance);
    }

    // 計算單一節點的平衡因子
