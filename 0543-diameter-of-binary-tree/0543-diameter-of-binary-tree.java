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
        info(int d , int h){
            this.diameter = d;
            this.height=h;
        }
    }
    // public int height(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }
    //     int left = height(root.left);
    //     int right = height(root.right);
    //     return Math.max(left,right)+1;
    // }
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root == null){
        //     return 0;
        // }
        // int right_diameter = diameterOfBinaryTree(root.right);
        // int right_height = height(root.right);
        // int left_height = height(root.left);
        // int left_diameter = diameterOfBinaryTree(root.left);
        // int total_diameter = right_height + left_height;
        // return Math.max(total_diameter , Math.max(right_diameter , left_diameter));
        info ans = diameter(root);
        return ans.diameter;
    }
    public info diameter(TreeNode root){
        if(root == null){
            return new info(0,0);
        }
        info rightInfo = diameter(root.right);
        info leftInfo = diameter(root.left);
        int diameter =Math.max(rightInfo.height+leftInfo.height,Math.max(leftInfo.diameter,rightInfo.diameter) );
        int height = Math.max(rightInfo.height,leftInfo.height)+1;
        return new info(diameter , height);
    }
}