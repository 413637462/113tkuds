class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeComparison {
    // 1. 判斷兩個二元樹是否完全相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    // 2. 判斷一個樹是否是另一個樹的子樹
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    // 3. 找出兩個樹的最大公共子樹
    private int maxSize = 0;
    private TreeNode result = null;
    
    public TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        findCommonSubtree(root1, root2);
        return result;
    }
    
    private int findCommonSubtree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return 0;
        
        int left = findCommonSubtree(node1.left, node2.left);
        int right = findCommonSubtree(node1.right, node2.right);
        
        int currentSize = 0;
        if (node1.val == node2.val) {
            currentSize = 1 + left + right;
            if (currentSize > maxSize) {
                maxSize = currentSize;
                result = node1;
            }
        }
        
        return currentSize;
    }
}