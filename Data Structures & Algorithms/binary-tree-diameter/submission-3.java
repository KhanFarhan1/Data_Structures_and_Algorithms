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
    class info{
        int diameter;
        int height;
        info(int d, int h){
            this.diameter = d;
            this.height = h;
        }
    }
    public info diameter(TreeNode root){
        if(root == null){
            return new info(0,0);
        }
        info rightinfo = diameter(root.right);
        info leftinfo = diameter(root.left);
        int total_diameter = Math.max(rightinfo.height + leftinfo.height , Math.max(rightinfo.diameter , leftinfo.diameter));
        return new info(total_diameter,Math.max(rightinfo.height,leftinfo.height)+1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diameter;
    }
}
