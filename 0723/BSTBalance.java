class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTBalance {
    // 1. 檢查BST是否為平衡樹
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // 2. 計算BST的平衡因子
    public int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
    
    // 3. 找出BST中最不平衡的節點
    private TreeNode mostUnbalancedNode = null;
    private int maxImbalance = 0;
    
    public TreeNode findMostUnbalancedNode(TreeNode root) {
        findUnbalanced(root);
        return mostUnbalancedNode;
    }
    
    private int findUnbalanced(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = findUnbalanced(node.left);
        int rightHeight = findUnbalanced(node.right);
        
        int currentImbalance = Math.abs(leftHeight - rightHeight);
        if (currentImbalance > maxImbalance) {
            maxImbalance = currentImbalance;
            mostUnbalancedNode = node;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}