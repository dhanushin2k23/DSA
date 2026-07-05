class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        
        if(root == null){
            return node;
        }

        TreeNode prev = null, curr = root;

        while(curr != null){
            if(val < curr.val){
                prev = curr;
                curr = curr.left;
                if(curr == null){
                    prev.left = node;
                    return root;
                }
            }else{
                prev = curr;
                curr = curr.right;
                if(curr == null){
                    prev.right = node;
                    return root;
                }
            }
        }
        return root;
    }
}