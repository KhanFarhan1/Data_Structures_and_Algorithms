/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p.val == root.val || q.val == root.val){
            return root;
        }
        TreeNode left_side = lowestCommonAncestor(root.left , p,q);
        TreeNode right_side = lowestCommonAncestor(root.right , p,q);
        if(left_side == null && right_side == null){
            return null;
        }
        if(left_side == null){
            return right_side;
        }
        if(right_side == null){
            return left_side;
        }
        return root;
    }
}