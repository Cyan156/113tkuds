import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        if (vals.size() < 2) return;

        int T = vals.get(vals.size() - 1);
        vals = vals.subList(0, vals.size() - 1);

        TreeNode root = buildTree(vals);
        int closest = closestValue(root, T);
        System.out.println(closest);
    }

    static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;
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

    static int closestValue(TreeNode root, int T) {
        int closest = root.val;
        TreeNode curr = root;

        while (curr != null) {
            int diffCurr = Math.abs(curr.val - T);
            int diffClosest = Math.abs(closest - T);
            if (diffCurr < diffClosest || (diffCurr == diffClosest && curr.val < closest)) {
                closest = curr.val;
            }
            if (T < curr.val) {
                curr = curr.left;
            } else if (T > curr.val) {
                curr = curr.right;
            } else {
                break; // exact match
            }
        }
        return closest;
    }
}

