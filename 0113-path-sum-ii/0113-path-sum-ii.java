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
    public List<List<Integer>> minfun(TreeNode root , int targetSum , int sum , List<Integer> ans , List<List<Integer>> list){
        if(root == null)return list;
        sum = sum + root.val;
        ans.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == sum){
                list.add(new ArrayList<>(ans));
            }
        }
        minfun(root.left , targetSum , sum , ans, list);
        minfun(root.right , targetSum , sum , ans,list);
        ans.remove(ans.size()-1);
        sum = sum - root.val;
        return list;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return minfun(root, targetSum, 0, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
}