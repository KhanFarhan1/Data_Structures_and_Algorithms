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
    public void swap(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode warp(TreeNode root){
        if(root == null){
            return null;
        }
        swap(root);
        warp(root.left);
        warp(root.right);
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        // if(root == null){
        //     return null;
        // }
        // TreeNode left_invert = invertTree(root.left);
        // TreeNode right_invert = invertTree(root.right);
        // root.left = right_invert;
        // root.right = left_invert;
        // return root;
        TreeNode ans = warp(root);
        return ans;
    }
}