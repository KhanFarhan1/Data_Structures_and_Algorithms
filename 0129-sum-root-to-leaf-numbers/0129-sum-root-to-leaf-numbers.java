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
    int ans = 0;
    public void minfun(TreeNode root ,int digit){
        if(root == null)return;
        if(digit == 0){
            digit = root.val;
        }else{
        digit = digit*10+root.val;
        }
        if(root.left == null && root.right == null){
            ans = ans + digit;
        }
        minfun(root.left ,  digit);
        minfun(root.right , digit);
        digit = digit/10;
    }
    public int sumNumbers(TreeNode root) {
        minfun(root , 0);
        return ans;
    }
}