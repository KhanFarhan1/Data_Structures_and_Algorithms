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

 /*
 In order to find linked list is valid palindrome we need to find 
 1. middle of l.l.
 2. middle is equal to slow
 3. reverse the another part 
 4. compare
 */
class Solution {
    public ListNode minfun(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null){
        return true;
      }
    ListNode middle = minfun(head);
    ListNode prev = null;
    ListNode curr = middle;
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
        if(right.val != left.val){
            return false;
        }
        left = left.next;
        right = right.next;
    }
    return true;
    }
}