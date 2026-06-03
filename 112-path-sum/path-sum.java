class Solution {
    private boolean result;


    public void helper(TreeNode node, int targetSum, int sum){
        if(node == null){
            return;
        }

        if(result){
            return;
        }

        sum = sum + node.val;

        if(node.left==null && node.right==null){
            if(sum==targetSum){
                result = true;
            }
            return;
        }

        helper(node.left,targetSum,sum);
        helper(node.right,targetSum,sum);


    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        result = false;
        
        if(root == null){
            return result;
        }

        helper(root,targetSum,0);

        return result;

    }
}