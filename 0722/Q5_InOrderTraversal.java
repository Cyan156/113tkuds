class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q5_InOrderTraversal {
    public static void main(String[] args) {
        // 建立範例樹：
        //     4
        //    / \
        //   2   5
        //  / \
        // 1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.print("In-order traversal: ");
        inOrder(root);  // 預期輸出：1 2 3 4 5
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);              // 左
        System.out.print(root.val + " "); // 根
        inOrder(root.right);             // 右
    }
}
