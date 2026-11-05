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
    public int getMinimum(Stack<TreeNode> st){
        if(st.isEmpty()){
            return -1;
        }
        TreeNode curr = st.pop();
        TreeNode right = curr.right;
        while(right != null){
            st.push(right);
            right = right.left;
        }
        return curr.val;
    }
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        int ans = Integer.MAX_VALUE;
        TreeNode curr = root;
        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
        int curr_val = 0;
        int prev = -1;
        while(curr_val != -1){
        curr_val = getMinimum(st);
        if(prev == -1){
            prev = curr_val;
            continue;
        }
        ans = Math.min(ans , Math.abs(curr_val-prev));
        prev = curr_val;
        }
        return ans;
    }
}