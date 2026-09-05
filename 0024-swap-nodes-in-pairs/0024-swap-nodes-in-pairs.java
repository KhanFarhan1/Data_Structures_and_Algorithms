/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reverse(ListNode head , int k){
        ListNode curr = head;
        ListNode next;
        ListNode prev = null;
        for(int i = 0;i<k;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int size = 2;
       ListNode left = head;
       ListNode right ;
       ListNode prevleft = null;
       ListNode nextleft;
       ListNode res =null;
       while(true){
        right = left;
        for(int i = 0;i<size-1;i++){
            if(right == null){
                break;
            }
            right = right.next;
        }
        if(right != null){
        nextleft = right.next;
        if(res == null){
            res = right;
        }
        reverse(left , size);
        if(prevleft != null){
            prevleft.next = right;
        }
        prevleft = left;
        left = nextleft;
        }else{
            if(prevleft != null){
            prevleft.next = left;
            }
            break;

        }  

       }
       return res;
    }
}