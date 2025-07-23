import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeDistance {
    // 1. 計算樹中任意兩個節點之間的距離
    public int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLCA(root, p, q);
        return distanceFromNode(lca, p) + distanceFromNode(lca, q);
    }
    
    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    private int distanceFromNode(TreeNode source, TreeNode target) {
        if (source == null) return -1;
        if (source == target) return 0;
        
        int left = distanceFromNode(source.left, target);
        int right = distanceFromNode(source.right, target);
        
        if (left == -1 && right == -1) return -1;
        return 1 + (left != -1 ? left : right);
    }
    
    // 2. 找出樹的直徑（任意兩個節點間的最大距離）
    private int diameter = 0;
    
    public int treeDiameter(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }
    
    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        diameter = Math.max(diameter, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // 3. 找出距離根節點指定距離的所有節點
    public List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        findNodesAtK(root, k, result);
        return result;
    }
    
    private void findNodesAtK(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.val);
            return;
        }
        
        findNodesAtK(node.left, k - 1, result);
        findNodesAtK(node.right, k - 1, result);
    }
}