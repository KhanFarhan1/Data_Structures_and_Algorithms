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
        int height;
        boolean isbalance;
        info(int h , boolean b){
            this.height = h;
            this.isbalance = b;
        }
    }
    public info wrap(TreeNode root){
        if(root == null){
            return new info(0 , true);
        }
        info leftinfo = wrap(root.left);
        info rightinfo = wrap(root.right);
        int height = Math.max(leftinfo.height , rightinfo.height)+1;
        int diff = Math.abs(leftinfo.height-rightinfo.height);
        if(diff<=1){
        if(leftinfo.isbalance && rightinfo.isbalance){
        return new info(height , true);
            }   
        }
        return new info(height , false);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return wrap(root).isbalance;
    }
}
