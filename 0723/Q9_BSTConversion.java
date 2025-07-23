class TreeNode {
    int val;
    TreeNode left;  // 用於雙向鏈表：left為prev，right為next
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q9_BSTConversion {

    // 1. BST轉雙向鏈表 (inorder)
    static TreeNode prev = null;
    static TreeNode head = null;

    public static TreeNode bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        inorderConvert(root);
        return head;
    }

    private static void inorderConvert(TreeNode node) {
        if (node == null) return;
        inorderConvert(node.left);

        if (prev == null) head = node;
        else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        inorderConvert(node.right);
    }

    // 2. 排序陣列轉平衡BST
    public static TreeNode sortedArrayToBST(int[] arr) {
        return buildBST(arr, 0, arr.length - 1);
    }

    private static TreeNode buildBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, right);
        return root;
    }

    // 3. BST節點改成所有大於等於該節點的值總和（逆序中序累加）
    static int sum = 0;

    public static void convertBST(TreeNode root) {
        su
