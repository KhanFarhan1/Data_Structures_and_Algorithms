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
    public boolean isCompleteTree(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       ArrayList<TreeNode> list = new ArrayList<>();
       q.add(root);
       while(!q.isEmpty()){
        TreeNode curr = q.remove();
        list.add(curr);
        if(curr != null){
        q.add(curr.left);
        q.add(curr.right);
        }
       }
       boolean flag = false;
       for(int i = 0;i<list.size();i++){
        TreeNode c = list.get(i);
        if(c == null){
            flag = true;
        }
        if(flag && c != null){
            return false;
        }
       }
       return true;
    }
}