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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ll = new ListNode();
        ListNode currNode=ll ;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                currNode.next = l1;
                l1 = l1.next;
            }else{
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        while(l1 != null){
            currNode.next = l1;
            l1=l1.next;
            currNode = currNode.next;
        }
        
        while(l2 != null){
            currNode.next = l2;
            l2 =l2.next;
            currNode = currNode.next;
        }
        return ll.next;
    }
}