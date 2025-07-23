class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTValidation {
    private TreeNode prev = null;
    private TreeNode firstViolation = null;
    private TreeNode secondViolation = null;

    // 1. 驗證是否為有效的BST
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // 2. 找出不符合規則的節點
    public void findViolations(TreeNode root) {
        inorderTraversal(root);
        if (firstViolation != null && secondViolation != null) {
            System.out.println("Violation nodes: " + firstViolation.val + " and " + secondViolation.val);
        } else if (firstViolation != null) {
            System.out.println("Violation node: " + firstViolation.val);
        } else {
            System.out.println("No violations found");
        }
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        
        inorderTraversal(node.left);
        
        if (prev != null && node.val <= prev.val) {
            if (firstViolation == null) {
                firstViolation = prev;
            }
            secondViolation = node;
        }
        prev = node;
        
        inorderTraversal(node.right);
    }

    // 3. 計算需要移除多少個節點才能讓樹變成有效的BST
    public int countNodesToRemove(TreeNode root) {
        List<TreeNode> violations = new ArrayList<>();
        findViolationNodes(root, violations);
        return violations.size();
    }

    private void findViolationNodes(TreeNode node, List<TreeNode> violations) {
        if (node == null) return;
        
        if ((node.left != null && node.left.val >= node.val) ||
            (node.right != null && node.right.val <= node.val)) {
            violations.add(node);
        }
        
        findViolationNodes(node.left, violations);
        findViolationNodes(node.right, violations);
    }
}