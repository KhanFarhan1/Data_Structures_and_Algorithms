import java.util.HashMap;

class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, ListNode> map;

    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(ListNode node) {
        ListNode before = node.prev;
        ListNode after = node.next;

        before.next = after;
        after.prev = before;
    }

    private void insertAfterHead(ListNode node) {
        ListNode first = head.next;

        head.next = node;
        node.prev = head;

        node.next = first;
        first.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);

        deleteNode(node);
        insertAfterHead(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);

            node.val = value;

            deleteNode(node);
            insertAfterHead(node);
        } else {

            if (map.size() == capacity) {
                ListNode lru = tail.prev;

                deleteNode(lru);
                map.remove(lru.key);
            }

            ListNode newNode = new ListNode(key, value);

            insertAfterHead(newNode);
            map.put(key, newNode);
        }
    }
}