public static void inOrder(TreeNode root) {
    if (root == null) {
        return;
    }
    inOrder(root.left);    // 先遍历左子树
    System.out.print(root.val + " ");  // 访问根节点
    inOrder(root.right);   // 再遍历右子树
}
