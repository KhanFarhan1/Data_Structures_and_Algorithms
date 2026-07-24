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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prenode = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val != curr.next.val){
                curr = curr.next;
                prenode = prenode.next;
            }else{
                while(curr.next != null &&curr.val == curr.next.val){
                    curr = curr.next;
                }
               
                curr = curr.next;
                prenode.next = curr;
            }
        }
        return dummy.next;
    }
}