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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if((root == null && subroot == null) || (root != null && subroot == null)){
            return true;
        }
        if(root == null && subroot != null){
            return false;
        }
        if(root.val == subroot.val){
            if(isSametree(root,subroot)){
                return true;
            }
        }
            boolean left = isSubtree(root.left,subroot);
            boolean right = isSubtree(root.right,subroot);
            return left||right;
    }
    public boolean isSametree(TreeNode r1 , TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        } 
        if(r1.val != r2.val){
            return false;
        }
        boolean left_side = isSametree(r1.left , r2.left);
        boolean right_side = isSametree(r1.right , r2.right);
        return left_side && right_side;
    }
}