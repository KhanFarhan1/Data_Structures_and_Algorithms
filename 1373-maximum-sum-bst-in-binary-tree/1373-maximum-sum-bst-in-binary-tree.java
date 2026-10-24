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
    int max_sum = 0;
    //TreeNode point_root = null;
    class info{
        boolean is_valid;
        int sum;
        int min;
        int max;
        info(boolean v , int s , int min , int max){
            this.is_valid = v;
            this.sum = s;
            this.min = min;
            this.max = max;
        }
    }
    public info largest_size(TreeNode root){
        if(root == null){
            return new info(true , 0 ,Integer.MAX_VALUE , Integer.MIN_VALUE);
        }
        info left = largest_size(root.left);
        info right =largest_size(root.right);
        //boolean
        boolean curr = true;
        if(left.is_valid == false || right.is_valid == false ){
            curr = false;
        }
        if(root.val <= left.max || root.val >= right.min){
            curr = false;
        }
        
        //size
        int sum = left.sum + right.sum + root.val;
        //min
        int min = Math.min(root.val ,Math.min(left.min , right.min));
        //max
        int max = Math.max(root.val , Math.max(left.max , right.max));
        
        if(curr){
           max_sum = Math.max(max_sum , sum);
        }

        return new info(curr , sum , min , max); 
    }
    public int maxSumBST(TreeNode root) {
        largest_size(root);
        return max_sum;
    }
}