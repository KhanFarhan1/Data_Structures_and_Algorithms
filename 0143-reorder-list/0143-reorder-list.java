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
    public ListNode minfun(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        //finding middle

        if(head == null || head.next == null){
            return;
        }
       ListNode middle = minfun(head);

       //reverse from middle.next 
       ListNode prev = null;
       ListNode curr = middle.next;
       middle.next = null;
       ListNode next;
       while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }

       //swapping
       ListNode righthalf = prev;
       ListNode lefthalf = head;

        while(righthalf !=null){
            ListNode Leftnext = lefthalf.next;
            ListNode Rightnext = righthalf.next;
            lefthalf.next = righthalf;
            righthalf.next = Leftnext;
            lefthalf = Leftnext;
            righthalf = Rightnext;
        }
    }
}