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
// class Solution {
//     public boolean two_sum_bst(TreeNode root , int k , HashSet<Integer> freq){
//         if(root == null){
//             return false;
//         }
//         int diff = k-root.val;
//         if(freq.contains(diff)){
//            return true; 
//         }else{
//             freq.add(root.val);
//         }
//         boolean left = two_sum_bst(root.left , k ,freq);
//         boolean right = two_sum_bst(root.right , k ,freq);
//         return left || right ;
//     }
//     public boolean findTarget(TreeNode root, int k) {
//         HashSet<Integer> freq = new HashSet<>();
//         return two_sum_bst(root , k , freq);
//     }
// }

class Solution {
    public TreeNode getSmaller(Stack<TreeNode> asc){
        if(asc.isEmpty()){
            return null;
        }
        TreeNode smaller = asc.pop();
        TreeNode right_side = smaller.right;
        while(right_side != null){
            asc.push(right_side);
            right_side = right_side.left;
        }
        return smaller;
    }
    public TreeNode getbigger(Stack<TreeNode> des){
        if(des.isEmpty()){
            return null;
        }
        TreeNode larger = des.pop();
        TreeNode left_side = larger.left;
        while(left_side != null){
            des.push(left_side);
            left_side = left_side.right;
        }
        return larger;
    }
    public boolean findTarget(TreeNode root , int k){
        Stack<TreeNode> asc = new Stack<>();
        Stack<TreeNode> des = new Stack<>();
        TreeNode curr = root;
        while(curr != null){
            asc.push(curr);
            curr = curr.left;
        }
        curr = root;
        while(curr != null){
            des.push(curr);
            curr = curr.right;
        }
        int i = getSmaller(asc).val;
        int j = getbigger(des).val;
        while(i != j && i<j){
            if(i + j == k){
                return true;
            }
            if(i+j < k){
                i = getSmaller(asc).val;
            }else{
                j = getbigger(des).val;
            }
        } 
        return false;
    }
}