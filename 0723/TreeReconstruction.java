import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeReconstruction {
    private int preIndex = 0;
    private int postIndex;

    // 1. 根據前序和中序遍歷結果重建二元樹
    public TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreePreIn(preorder, 0, preorder.length - 1, inMap, 0, inorder.length - 1);
    }

    private TreeNode buildTreePreIn(int[] preorder, int preStart, int preEnd, 
                                  Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTreePreIn(preorder, preStart + 1, preStart + numsLeft, 
                                 inMap, inStart, inRoot - 1);
        root.right = buildTreePreIn(preorder, preStart + numsLeft + 1, preEnd, 
                                  inMap, inRoot + 1, inEnd);
        
        return root;
    }

    // 2. 根據後序和中序遍歷結果重建二元樹
    public TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        postIndex = postorder.length - 1;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreePostIn(postorder, inMap, 0, inorder.length - 1);
    }

    private TreeNode buildTreePostIn(int[] postorder, Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int inRoot = inMap.get(root.val);
        
        root.right = buildTreePostIn(postorder, inMap, inRoot + 1, inEnd);
        root.left = buildTreePostIn(postorder, inMap, inStart, inRoot - 1);
        
        return root;
    }

    // 3. 驗證重建的樹是否正確
    public boolean validateReconstruction(TreeNode root, int[] expectedPreorder, int[] expectedInorder) {
        List<Integer> actualPre = new ArrayList<>();
        List<Integer> actualIn = new ArrayList<>();
        
        preOrderTraversal(root, actualPre);
        inOrderTraversal(root, actualIn);
        
        return Arrays.equals(actualPre.stream().mapToInt(i->i).toArray(), expectedPreorder) &&
               Arrays.equals(actualIn.stream().mapToInt(i->i).toArray(), expectedInorder);
    }

    private void preOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.val);
        inOrderTraversal(node.right, result);
    }
}