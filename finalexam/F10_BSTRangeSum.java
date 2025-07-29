import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static TreeNode buildBST(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].equals("-1")) {
                insertBST(root, Integer.parseInt(nodes[i]));
            }
        }
        return root;
    }

    private static void insertBST(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertBST(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        int L = sc.nextInt();
        int R = sc.nextInt();
        
        TreeNode root = buildBST(nodes);
        System.out.println(rangeSumBST(root, L, R));
    }
}

