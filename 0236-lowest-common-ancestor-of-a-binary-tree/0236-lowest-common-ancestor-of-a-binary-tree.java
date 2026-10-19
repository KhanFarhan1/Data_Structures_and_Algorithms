// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public int wrap(TreeNode root , TreeNode p , TreeNode q , int ans){
//         if(root == null){
//             return 0;
//         }
//         int left = wrap(root.left,p,q,ans);
//         int right = wrap(root.right,p,q,ans);
//         int count = 0;
//         if(root.val == p.val || root.val == q.val){
//             count = 1;
//         }
//         int total = left+right+count;
//         if(total == 2 && ans == Integer.MIN_VALUE){
//             return root.val;
//         }
//         return total;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         int ans = Integer.MIN_VALUE;
//         int val = wrap(root , p ,q, ans);
//         TreeNode node = new TreeNode(val = val);
//         return node;
//     }
// }
// class Solution {
//     private TreeNode ans = null;
//     public int wrap(TreeNode root , TreeNode p , TreeNode q){
//         if(root == null){
//             return 0;
//         }
//         int left = wrap(root.left,p,q);
//         int right = wrap(root.right,p,q);
//         int count = 0;
//         if(root.val == p.val || root.val == q.val){
//             count = 1;
//         }
//         int total = left+right+count;
//         if(total == 2 && ans == null){
//            ans = root;
//         }
//         return total;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         wrap(root , p ,q);
//         return ans;
//     }
// }

class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p,  q);
        TreeNode right = lowestCommonAncestor(root.right, p,  q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}