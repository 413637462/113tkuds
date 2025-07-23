import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreePathProblems {
    // 1. 找出從根節點到所有葉節點的路徑
    public List<List<Integer>> findAllPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        dfsFindPaths(root, new ArrayList<>(), paths);
        return paths;
    }

    private void dfsFindPaths(TreeNode node, List<Integer> currentPath, List<List<Integer>> paths) {
        currentPath.add(node.val);
        
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            if (node.left != null) dfsFindPaths(node.left, currentPath, paths);
            if (node.right != null) dfsFindPaths(node.right, currentPath, paths);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }

    // 2. 判斷樹中是否存在和為目標值的根到葉路徑
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 3. 找出樹中和最大的根到葉路徑
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return maxPathSumHelper(root);
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        if (node.left == null && node.right == null) return node.val;
        
        int leftSum = maxPathSumHelper(node.left);
        int rightSum = maxPathSumHelper(node.right);
        
        return node.val + Math.max(leftSum, rightSum);
    }
}