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
    public TreeNode getSmaller(Stack<TreeNode> acs){
        if(acs.isEmpty()){
            return null;
        }
        TreeNode curr = acs.pop();
        TreeNode right_side = curr.right;
        while(right_side != null){
            acs.push(right_side);
            right_side = right_side.left;
        }
        return curr;
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> acs = new Stack<>();
        while(curr != null){
            acs.push(curr);
            curr = curr.left;
        }
        int ans = -1;
        while(k > 0){
            ans = getSmaller(acs).val;
            k--;
        }
        return ans;
    }
}