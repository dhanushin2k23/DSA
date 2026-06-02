class Solution {
    
    public void helperFunc(TreeNode node,List<Integer> out){
        if(node == null){
            return;
        }

        helperFunc(node.left,out);
        helperFunc(node.right,out);
        out.add(node.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();

        if(root == null){
            return out;
        }

        helperFunc(root,out);

        return out;
    }
}