class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val,
            qVal = q.val;

        TreeNode curr = root;

        while(curr != null){
            if(pVal > curr.val && qVal > curr.val){
                curr = curr.right;
            }else if(pVal < curr.val && qVal < curr.val){
                curr = curr.left;
            }else{
                return curr;
            }
        }

        return null;
    }
}