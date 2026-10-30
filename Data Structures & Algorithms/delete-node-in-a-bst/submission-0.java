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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val > key){
            root.left = deleteNode(root.left , key);
        }else if(root.val < key){
            root.right = deleteNode(root.right , key);
        }else{
            //case we deletion occurs
            //case1 : node is leaf node i.e. no left and right sub-node
            if(root.left == null && root.right == null){
                return null;
            }
            //case2 : node has either one left or one right 
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //case3 : node has both left and right node
            //for this case we need a element in a tree which is  "right and leftmost element of the deleting one node"  
            TreeNode element = RightLeftmost_node(root.right);
            root.val = element.val;
            root.right = deleteNode(root.right , element.val);
        }
        return root;
    }
    public TreeNode RightLeftmost_node(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}