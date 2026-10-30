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
    HashMap<Integer , Integer> freq = new HashMap<>();
    int idx = 0;
    public void mapfun(int[] inorder , HashMap<Integer , Integer> freq){
        for(int i = 0 ; i<inorder.length ; i++){
            freq.put(inorder[i] , i);
        }
    }
    public TreeNode constructTree(int[] postorder , int si , int ei){
        if(si > ei )return null;
        TreeNode root = new TreeNode();
        root.val = postorder[idx];
        idx--;
        int point = freq.get(root.val);
        root.right = constructTree(postorder , point+1 , ei);
        root.left = constructTree(postorder , si , point-1 );
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        mapfun(inorder , freq);
        return constructTree(postorder , 0 , inorder.length-1);
    }
}