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
    public boolean sum_path( ArrayList<Integer> ans , int targetSum){
        int sum = 0 ;
        for(int i = 0 ;i< ans.size() ; i++){
            sum = sum + ans.get(i);
        }
        if(sum == targetSum){
            return true;
        }else{
            return false;
        }
    }
    public boolean cal_path(TreeNode root , int targetSum , ArrayList<Integer> ans){
        if(root == null){
            return false;
        }
        ans.add(root.val);
        if(root.left == null && root.right == null){
            if(sum_path(ans , targetSum))return true;
        }
        boolean left = cal_path(root.left , targetSum , ans);
        boolean right =cal_path(root.right , targetSum , ans);
        ans.remove(ans.size()-1);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> ans = new ArrayList<>();
        return cal_path(root , targetSum , ans);
    }
}