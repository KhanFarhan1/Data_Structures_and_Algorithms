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
    public List<Integer> wrap(TreeNode root , List<Integer> ans){
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        wrap(root.left ,ans);
        wrap(root.right,ans);
        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return wrap(root , ans);
    }
}