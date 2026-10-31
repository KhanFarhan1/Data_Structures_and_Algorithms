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
    int res = 0;
    public int helperfun(TreeNode root){
        if(root == null) return 0;
        int leftMax = helperfun(root.left);
        int rightMax = helperfun(root.right);
        leftMax = Math.max(leftMax , 0);
        rightMax = Math.max(rightMax , 0);
        res = Math.max(res , root.val+leftMax+rightMax);
        return root.val+Math.max(leftMax, rightMax);
    }
    public int maxPathSum(TreeNode root) {
        res = root.val;
        helperfun(root);
        return res;
    }
}