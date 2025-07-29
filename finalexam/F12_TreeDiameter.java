import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    private static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }
    
    private static int height(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
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
        System.out.println(diameterOfBinaryTree(root));
    }
}

