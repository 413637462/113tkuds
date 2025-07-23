class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int x) { val = x; }
}

public class BSTKthElement {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(BSTNode root, int k) {
        count = 0;
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(BSTNode node, int k) {
        if (node == null) return;
        
        inOrderTraversal(node.left, k);
        
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        
        inOrderTraversal(node.right, k);
    }
}