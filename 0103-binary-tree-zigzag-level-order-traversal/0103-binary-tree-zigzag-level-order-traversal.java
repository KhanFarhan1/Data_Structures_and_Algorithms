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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
         return ans;   
        }
        q.add(root);
        q.add(null);
        boolean toogle = true;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(toogle){
                    toogle = false;
                }else{
                    Collections.reverse(res);
                    toogle = true;
                }
                ans.add(new ArrayList<>(res));
                res.clear();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                res.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}