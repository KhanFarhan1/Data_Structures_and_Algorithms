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
    public boolean cal_path(TreeNode root , int targetSum , int sum){
        if(root == null){
            return false;
        }
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum)return true;
        }
        boolean left = cal_path(root.left , targetSum , sum);
        boolean right =cal_path(root.right , targetSum , sum);
        sum = sum - root.val;
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return cal_path(root , targetSum , 0);
    }
}