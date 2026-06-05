class Solution {
    public TreeNode invertTreeHelper(TreeNode node){
        if(node == null){
            return null;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = invertTreeHelper(right);
        node.right = invertTreeHelper(left);

        return node;
    }
    
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }
}