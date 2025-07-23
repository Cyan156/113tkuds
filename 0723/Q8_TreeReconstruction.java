import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q8_TreeReconstruction {

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int ri = inMap.get(pre[ps]);
        int leftSize = ri - is;
        root.left = buildPreIn(pre, ps + 1, ps + leftSize, in, is, ri - 1, inMap);
        root.right = buildPreIn(pre, ps + leftSize + 1, pe, in, ri + 1, ie, inMap);
        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(post[pe]);
        int ri = inMap.get(post[pe]);
        int leftSize = ri - is;
        root.left = buildPostIn(post, ps, ps + leftSize - 1, in, is, ri - 1, inMap);
        root.right = buildPostIn(post, ps + leftSize, pe - 1, in, ri + 1, ie, inMap);
        return root;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder =  {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode fromPreIn = buildFromPreIn(preorder, inorder);
        TreeNode fromPostIn = buildFromPostIn(postorder, inorder);

        printInorder(fromPreIn);
        System.out.println();
        printInorder(fromPostIn);
        System.out.println();
    }
}
