import java.util.ArrayList;

class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int x) { val = x; }
}

public class BSTRangeQuery {
    public ArrayList<Integer> rangeQuery(BSTNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderRangeQuery(root, min, max, result);
        return result;
    }

    private void inOrderRangeQuery(BSTNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) return;
        
        // 中序遍歷保證結果有序
        if (node.val > min) {
            inOrderRangeQuery(node.left, min, max, result);
        }
        
        if (node.val >= min && node.val <= max) {
            result.add(node.val);
        }
        
        if (node.val < max) {
            inOrderRangeQuery(node.right, min, max, result);
        }
    }
}