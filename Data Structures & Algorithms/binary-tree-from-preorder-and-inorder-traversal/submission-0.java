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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            hm.put(inorder[i], i);
            
        }
        return splitTree(preorder, hm, 0, 0, inorder.length-1);
    }
     public TreeNode splitTree(int[] preorder, HashMap<Integer, Integer> hm, int rootIndex, int left, int right){
        TreeNode root = new TreeNode(preorder[rootIndex]);

        // create left and right subtree
        int mid = hm.get(preorder[rootIndex]);
        if(mid > left){
            root.left = splitTree(preorder, hm, rootIndex + 1, left, mid-1);
        }

        if(mid < right){
            root.right = splitTree(preorder, hm, rootIndex + mid - left + 1, mid+1, right);
        }
        return root;
    }
}
