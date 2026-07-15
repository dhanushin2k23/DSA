class Solution {
    public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        
        int mid = start + (end - start) / 2;

        int nodeVal = nums[mid];

        TreeNode node = new TreeNode(nodeVal);

        node.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, end);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortedArrayToBSTHelper(nums , 0, nums.length -1);
        return root;
    }
}