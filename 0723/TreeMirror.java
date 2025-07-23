class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeMirror {
    // 1. 判斷一個二元樹是否是對稱的
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 2. 將二元樹轉換為其鏡像樹
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }

    // 3. 比較兩個二元樹是否互為鏡像
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        return (t1.val == t2.val) 
            && isMirror(t1.left, t2.right) 
            && isMirror(t1.right, t2.left);
    }
}