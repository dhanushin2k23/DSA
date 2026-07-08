class Solution {
    public boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if ((upper != null && node.val >= upper) || (lower != null && node.val <= lower)) {
            return false;
        }

        boolean left = isValidBSTHelper(node.left, lower, node.val);

        if (!left) {
            return false;
        }

        return isValidBSTHelper(node.right, node.val, upper);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root , null , null);
    }
}