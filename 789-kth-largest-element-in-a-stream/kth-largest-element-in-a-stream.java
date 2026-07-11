class TreeNode{
    int val;
    int count;

    TreeNode left;
    TreeNode right;

    public TreeNode(int x){
        this.val =x;
        this.count =1;
    }
}
class KthLargest {
    TreeNode root;
    int kVal;
    
    public KthLargest(int k, int[] nums) {
        this.kVal =k;

        for(int num : nums){
            insertinBst(num);
        }

    }

    public void insertinBst(int val){
        if(root == null){
            root = new TreeNode(val);
            return;
        }

        TreeNode curr = root;
        TreeNode node = new TreeNode(val);

        while(curr != null){
            curr.count = curr.count + 1;
            if(val > curr.val){
                if(curr.right == null){
                    curr.right = node;
                    return;
                }
                curr = curr.right;
            }else{
                if(curr.left == null){
                    curr.left = node;
                    return;
                }
                curr = curr.left;
            }
        }
    }

    public int search(){
        int kT = this.kVal;
        TreeNode curr = root;

        while(curr != null){
            int rC = curr.right != null ? curr.right.count : 0;

            if(kT == rC + 1){
                return curr.val;
            }else if(kT <= rC){
                curr = curr.right;
            }else{
                kT = kT - rC -1;
                curr = curr.left;
            }
        }
        return -1;
    }
    
    public int add(int val) {
        insertinBst(val);
        return search();
    }
}