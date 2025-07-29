import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDiameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        if (vals.isEmpty()) return;

        TreeNode root = buildTree(vals);
        maxDiameter = 0;
        height(root);
        System.out.println(maxDiameter);
    }

    static TreeNode buildTree(List<Integer> vals) {
        if (vals.get(0) == -1) return null;
        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;
        while (!q.isEmpty() && idx < vals.size()) {
            TreeNode node = q.poll();
            int leftVal = vals.get(idx++);
            if (leftVal != -1) {
                node.left = new TreeNode(leftVal);
                q.offer(node.left);
            }
            if (idx < vals.size()) {
                int rightVal = vals.get(idx++);
                if (rightVal != -1) {
                    node.right = new TreeNode(rightVal);
                    q.offer(node.right);
                }
            }
        }
        return root;
    }

    // 回傳節點高度（節點數計），同時更新 maxDiameter（邊數）
    static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // 節點間邊數 = 節點數 - 1
        int diameterThroughNode = leftHeight + rightHeight;
        if (diameterThroughNode > maxDiameter) {
            maxDiameter = diameterThroughNode;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}


