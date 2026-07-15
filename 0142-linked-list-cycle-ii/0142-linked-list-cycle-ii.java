/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                int i =0;
                while(slow != fast){
                slow = slow.next;
                fast = fast.next;
                i++;
                }
                return fast;
            }
        }
        return null;
    }
}