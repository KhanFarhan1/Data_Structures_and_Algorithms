/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        HashMap<ListNode , Integer> freq = new HashMap<>();
        while(tempA != null){
            freq.put(tempA , freq.getOrDefault(tempA , 0)+1);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while(tempB != null){
            if(freq.getOrDefault(tempB,0) > 0){
                return tempB;
            }else{
                tempB = tempB.next;
            }
        }
        return null;
    }
}