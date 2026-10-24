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
    public ArrayList<TreeNode> bst_to_list(TreeNode root , ArrayList<TreeNode> ans){
        if(root == null){
            return ans;
        }
        bst_to_list(root.left , ans);
        ans.add(root);
        bst_to_list(root.right , ans);
        return ans;
    }
    public TreeNode list_to_bal_tree(ArrayList<TreeNode> arr , int si , int ei){
        if(si > ei){
            return null;
        }
        int mid = si + (ei -si)/2;
        TreeNode root = new TreeNode(arr.get(mid).val);
        root.left = list_to_bal_tree(arr , si , mid-1);
        root.right = list_to_bal_tree(arr , mid+1 , ei);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> ans = bst_to_list(root , new ArrayList<>());
        return list_to_bal_tree(ans , 0 , ans.size()-1 );
    }
}