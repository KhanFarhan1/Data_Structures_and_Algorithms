/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null ){
            return head;
        }
        Node curr = head;
        while(curr != null){
            Node newnode = new Node(curr.val);
            newnode.next = curr.next;
            curr.next = newnode;
            curr = curr.next.next;
        }
        curr = head;
        while(curr !=null){
            if(curr.random != null){
            curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node odd = head;
        Node even = head.next;
        Node newHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = null;
        return newHead;
    }
}