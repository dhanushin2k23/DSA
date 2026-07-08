class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, curr = root;

        //basic search operation;
        while(curr != null && curr.val != key){
            parent = curr;
            if(key < curr.val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        if(curr == null){
            return root;
        }

        if(curr.left != null && curr.right != null){
            //curr has two child;
            TreeNode successor = curr.right;
            TreeNode successorParent = curr;

            while(successor.left != null){
                successorParent = successor;
                successor = successor.left;
            }

            curr.val = successor.val;

            curr = successor;
            parent = successorParent;
        }
        
        //case when key is a leaf node;
        if(curr.left == null && curr.right == null){
            if(parent == null){
                //root to be deleted;
                return null;
            }
            
            if(curr == parent.right){
                parent.right = null;
            }else{
                parent.left = null;
            }
        //case when there is only one child;
        }else if(curr.left == null || curr.right == null){
            if(parent==null){
                return curr.left != null ? curr.left : curr.right;
            }
            
            if(curr == parent.right){
                parent.right = curr.left != null ? curr.left : curr.right;
            }else{
                parent.left = curr.left != null ? curr.left : curr.right;
            }
        }

        return root;
    }
}