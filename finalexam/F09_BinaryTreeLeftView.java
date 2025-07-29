import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result.add(node.val); 
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();
            
            if (!nodes[index].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(current.left);
            }
            index++;
            
            if (index < nodes.length && !nodes[index].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(current.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        TreeNode root = buildTree(nodes);
        List<Integer> leftView = leftSideView(root);
        
        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
    }
}
