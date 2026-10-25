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
    public boolean two_sum_bst(TreeNode root , int k , HashSet<Integer> freq){
        if(root == null){
            return false;
        }
        int diff = k-root.val;
        if(freq.contains(diff)){
           return true; 
        }else{
            freq.add(root.val);
        }
        boolean left = two_sum_bst(root.left , k ,freq);
        boolean right = two_sum_bst(root.right , k ,freq);
        return left || right ;
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> freq = new HashSet<>();
        return two_sum_bst(root , k , freq);
    }
}