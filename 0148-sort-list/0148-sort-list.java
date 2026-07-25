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
    public ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;// for even case of linked list we need one less linked list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergetwolist(ListNode head1 , ListNode head2){
        ListNode h1 = head1;
        ListNode h2 = head2;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }
       if(h1 != null){
        temp.next = h1;
       }
       if(h2 != null){
        temp.next = h2;
       }
       return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = findmid(head);
        ListNode righthalf = middle.next;
        middle.next = null;

        ListNode newleft = sortList(head);
        ListNode newright = sortList(righthalf);
        
        return mergetwolist(newleft,newright);
    }
}