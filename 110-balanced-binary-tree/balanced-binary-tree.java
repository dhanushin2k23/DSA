class Solution {
    public int height(TreeNode node) {
    if (node == null) return 0;
    
    int left = height(node.left);
    int right = height(node.right);
    
    if (left == -1 || right == -1) return -1;
    if (Math.abs(left - right) > 1) return -1;
    
    return Math.max(left, right) + 1;
}
    public boolean isBalanced(TreeNode root) {
        boolean result = true;

        if(height(root) == -1){
            result = false;
        }

        return result;
    }
}