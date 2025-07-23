class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class DoublyListNode {
    int val;
    DoublyListNode prev, next;
    DoublyListNode(int x) { val = x; }
}

public class BSTConversion {
    private TreeNode prev = null;
    private TreeNode head = null;
    
    // 1. 將BST轉換為排序的雙向鏈表
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        inorderConvert(root);
        
        // 將TreeNode轉換為DoublyListNode
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode curr = dummy;
        TreeNode node = head;
        
        while (node != null) {
            DoublyListNode newNode = new DoublyListNode(node.val);
            curr.next = newNode;
            newNode.prev = curr;
            curr = curr.next;
            node = node.right;
        }
        
        if (dummy.next != null) {
            dummy.next.prev = null;
        }
        
        return dummy.next;
    }
    
    private void inorderConvert(TreeNode node) {
        if (node == null) return;
        
        inorderConvert(node.left);
        
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        
        inorderConvert(node.right);
    }
    
    // 2. 將排序陣列轉換為平衡的BST
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        
        return node;
    }
    
    // 3. 將BST的每個節點值改為所有大於等於該節點值的節點值總和
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    
    private void reverseInorder(TreeNode node) {
        if (node == null) return;
        
        reverseInorder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorder(node.left);
    }
}