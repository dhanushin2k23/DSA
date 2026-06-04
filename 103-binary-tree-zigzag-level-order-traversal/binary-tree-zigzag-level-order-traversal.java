
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null){
            return out;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount =0;

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = queue.remove();
                level.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

            if(levelCount % 2 != 0){
                Collections.reverse(level);
            }
            out.add(level);
            levelCount++;
        }
        return out;
    }
}