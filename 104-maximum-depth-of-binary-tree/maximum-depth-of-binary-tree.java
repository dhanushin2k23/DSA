 class Solution {
    private int answer;
    
    public void maxDepthHelper(TreeNode node,int val){
        if(node == null){
            return;
        }

        answer = Math.max(answer,val);

        maxDepthHelper(node.left,val + 1);
        maxDepthHelper(node.right,val + 1);

    }
    
    public int maxDepth(TreeNode root) {
        answer =0;

        maxDepthHelper(root,1);

        return answer;
    }
}