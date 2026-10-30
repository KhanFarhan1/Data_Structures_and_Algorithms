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
    public void map(int[] inorder , HashMap<Integer , Integer> freq){
        for(int i = 0; i<inorder.length ; i++){
            freq.put(inorder[i] , i);
        }
    }
    public TreeNode constructTree(int[] preorder,int si , int ei){
        if(si > ei){
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[idx];
        idx++;
        int point = freq.get(root.val);
        root.left = constructTree(preorder , si ,point-1);
        root.right = constructTree(preorder , point+1 ,ei);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map(inorder , freq);
        return constructTree(preorder , 0 , preorder.length-1);
    }
}