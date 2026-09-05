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
    public void reverse(ListNode head , int size){
        ListNode curr = head;
        ListNode next;
        ListNode prev = null;
        for(int i = 0;i<size;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
       ListNode left = head;
       ListNode right;
       ListNode res = null;
       ListNode nextLeft;
       ListNode prevLeft=null;
       while(true){
        right = left;
        for(int i =0;i<k-1;i++){
            if(right == null){
                break;
            }
            right = right.next;
        }
        if(right != null){
            nextLeft = right.next;
            reverse(left , k);
            if(prevLeft !=null){
                prevLeft.next = right;
            }
            if(res == null){
                res = right;
            }
            prevLeft = left;
            left = nextLeft;
        }else{
            if(prevLeft != null){
                prevLeft.next = left;
            }
            break;
        }
       }
       return res;
    }
}