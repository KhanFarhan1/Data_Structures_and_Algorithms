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
    public ListNode removeElements(ListNode head, int target) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
           // ListNode next = curr.next;
            if(curr.val==target){
                prev.next = prev.next.next; 
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}