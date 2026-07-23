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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next ==null ){
            return head;
        }

       int size =1 ;
       ListNode temp = head;
       while(temp.next != null){
        temp=temp.next;
        size++;
       }
       ListNode right_postion = head;
       k = k%size;
       if(k == 0){
        return head;
       }
       int i= 0; 
       while(i != size-k-1){
        right_postion=right_postion.next;
        i++;
       }
       ListNode newHead = right_postion.next;
       right_postion.next = null;
       temp.next = head;
       return newHead;
    }
}