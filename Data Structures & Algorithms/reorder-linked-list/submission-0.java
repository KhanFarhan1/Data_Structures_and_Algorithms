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
        if(head == null || head.next == null ){
            return;
        }
        ListNode middle = minfun(head);

        ListNode prev =null; 
        ListNode curr = middle.next;
        middle.next = null;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
        ListNode left = head;
        while(right != null){
            ListNode rightnext= right.next;
            ListNode leftnext = left.next;
            left.next = right;
            right.next = leftnext;
            left = leftnext;
            right = rightnext;
        }
    }
}
