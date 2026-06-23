/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] preorderArray;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    /**
     * Constructs a binary tree from preorder and inorder traversal arrays.
     * @param preorder array representing preorder traversal of the tree
     * @param inorder array representing inorder traversal of the tree
     * @return root node of the constructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int totalNodes = preorder.length;
        this.preorderArray = preorder;
      
        // Build a map for quick lookup of each value's index in inorder array
        for (int i = 0; i < totalNodes; ++i) {
            inorderIndexMap.put(inorder[i], i);
        }
      
        // Start recursive construction from the entire array range
        return dfs(0, 0, totalNodes);
    }

    /**
     * Recursively constructs a subtree using depth-first search.
     * @param preorderStartIndex starting index in preorder array for current subtree
     * @param inorderStartIndex starting index in inorder array for current subtree
     * @param subtreeSize number of nodes in current subtree
     * @return root node of the constructed subtree
     */
    private TreeNode dfs(int preorderStartIndex, int inorderStartIndex, int subtreeSize) {
        // Base case: empty subtree
        if (subtreeSize <= 0) {
            return null;
        }
      
        // The first element in preorder segment is always the root
        int rootValue = preorderArray[preorderStartIndex];
      
        // Find root's position in inorder array
        int rootInorderIndex = inorderIndexMap.get(rootValue);
      
        // Calculate size of left subtree
        int leftSubtreeSize = rootInorderIndex - inorderStartIndex;
      
        // Recursively build left subtree
        // Left subtree's preorder starts right after current root
        // Left subtree's inorder starts at same position
        TreeNode leftChild = dfs(preorderStartIndex + 1, inorderStartIndex, leftSubtreeSize);
      
        // Recursively build right subtree
        // Right subtree's preorder starts after root and entire left subtree
        // Right subtree's inorder starts right after root position
        // Right subtree size = total size - 1 (root) - left subtree size
        TreeNode rightChild = dfs(preorderStartIndex + 1 + leftSubtreeSize, 
                                 rootInorderIndex + 1, 
                                 subtreeSize - 1 - leftSubtreeSize);
      
        // Create and return root node with constructed children
        return new TreeNode(rootValue, leftChild, rightChild);
    }
}