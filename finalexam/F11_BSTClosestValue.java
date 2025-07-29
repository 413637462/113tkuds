import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            } else if (Math.abs(root.val - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, root.val);
            }
            
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
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
        int target = sc.nextInt();
        
        TreeNode root = buildBST(nodes);
        System.out.println(closestValue(root, target));
    }
}

