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
 for every list
    add its head to the priority queue

while priority queue is not empty
    remove the smallest node
    attach it to the answer
    if removed node has a next node
        add that next node to the priority queue
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode dummy = new ListNode();
      ListNode curr = dummy;
      PriorityQueue<ListNode> pq = new PriorityQueue<>(
        (a,b)->{
            return a.val-b.val;
        }
      );
      for(int i = 0;i<lists.length;i++){
        if(lists[i] != null)
        pq.add(lists[i]);
      }
      while(!pq.isEmpty()){
        ListNode node = pq.poll();
        curr.next = node;
        curr = curr.next;
        if(node.next != null){
            pq.add(node.next);
        } 
      }
      return dummy.next;
    }
}