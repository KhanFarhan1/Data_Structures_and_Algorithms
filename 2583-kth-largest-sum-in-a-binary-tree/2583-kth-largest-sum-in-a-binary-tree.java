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
    public List<Long> wrap(TreeNode root,List<Long> ans,Long sum){
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    ans.add(sum);
                    return ans;
                }else{
                    q.add(null);
                    ans.add(sum);
                    sum=0L;
                }
            }else{
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                sum = sum + curr.val;
            }
        }
        return ans;
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> ans = wrap(root,new ArrayList<Long>(),0L);
        Collections.sort(ans);
        int indx = ans.size()-k;
        if(indx < 0){
            return -1;
        }
        return ans.get(indx);
    }
}