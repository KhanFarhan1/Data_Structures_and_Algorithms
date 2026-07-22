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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //Dummy Node technique
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode curr = head;
        //Go to left node 
        for(int i = 0;i<left-1;i++){
            preNode = preNode.next;
            curr = curr.next;
        }
        //Mark the curr node for connection
        ListNode mark = curr;

        //reverse
        ListNode prev = null;
        ListNode next;
        for(int i = 0;i<right-left+1;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //connection
        preNode.next = prev;
        mark.next = curr;

        
    return dummy.next;
    }
}