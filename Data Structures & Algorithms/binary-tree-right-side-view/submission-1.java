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
        int Vv;
        TreeNode bt;
        info(int v , TreeNode b){
            this.Vv = v;
            this.bt = b;
        }
    }
    int right_val = 0;
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<info> q = new LinkedList<>();
        HashMap<Integer , TreeNode> freq = new HashMap<>();
        q.add(new info(0 , root));
        q.add(null);
        int max =Integer.MIN_VALUE;
        while(!q.isEmpty()){
            info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    ans.add(right_val);
                    break;
                }else{
                    ans.add(right_val);
                    q.add(null);
                }
            }else{
                int postion=curr.Vv;
                TreeNode postion_node = curr.bt;
                right_val=postion_node.val;
                if(postion_node.left != null ){
                    q.add(new info(postion-1 , postion_node.left));
                }
                if(postion_node.right != null ){
                    q.add(new info(postion+1 , postion_node.right));
                }
            }
        }
        return ans;
    }
}
