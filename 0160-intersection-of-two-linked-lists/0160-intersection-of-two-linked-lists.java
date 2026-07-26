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
        //Native Approach:  want we have to do is just loop and store all value of headA 
        //in hashmap then do again a loop in headB inhich we cheack node is there or not 
        //!!!
        //
        // ListNode tempA = headA;
        // HashMap<ListNode , Integer> freq = new HashMap<>();
        // while(tempA != null){
        //     freq.put(tempA , freq.getOrDefault(tempA , 0)+1);
        //     tempA = tempA.next;
        // }
        // ListNode tempB = headB;
        // while(tempB != null){
        //     if(freq.getOrDefault(tempB,0) > 0){
        //         return tempB;
        //     }else{
        //         tempB = tempB.next;
        //     }
        // }
        // return null;


        //Optimal Approach:

        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2){
                return temp1;
            }

            if(temp1 == null){
                temp1 = headB;
            }
            if(temp2 == null){
                temp2 = headA;
            }
        }
        return temp1;
    }
}