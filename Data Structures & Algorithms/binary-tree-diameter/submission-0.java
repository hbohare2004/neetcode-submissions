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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNode root){
       if(root == null){
        return 0;
       }

       int leftPath = longestPath(root.left);
       int rightPath = longestPath(root.right);
       diameter = Math.max(leftPath + rightPath, diameter);
       return Math.max(leftPath, rightPath) + 1;
    }
}
