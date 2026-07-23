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
 1. find size of the l.l.
 2. now find right_postion where to split it 
 for this there is technique k = k%size
 3. loop it till we go to right_postion 
 4 connect
  */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode temp = head;
        int size =1;
        while(temp.next != null ){
            temp = temp.next;
            size++;
        }
        k = k%size;
        if(k == 0){
            return head;
        }
        ListNode right_postion = head;
        int i =0;
        while(i!=size-k-1){
            right_postion = right_postion.next;
            i++;
        }
        ListNode newHead = right_postion.next;
        right_postion.next = null;
        temp.next = head;
        return newHead;
    }
}