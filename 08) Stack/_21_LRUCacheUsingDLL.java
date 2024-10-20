import java.util.HashMap;

public class _21_LRUCacheUsingDLL {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    class LRUCache {

        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) { // O(1)
            if(!map.containsKey(key))
                return -1;

            Node node = map.get(key);
            delete(node);
            insertAtFront(key, node.value);
            return node.value;
        }
        
        public void put(int key, int value) { // O(1)

            if(map.containsKey(key)) {
                delete(map.get(key));
            }

            if(map.size() == capacity) {
                delete(tail.prev);
            }

            insertAtFront(key, value);
        }

        private void insertAtFront(int key, int value) { // O(1)
            Node newNode = new Node(key, value);

            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;

            map.put(key, newNode);
        }

        private void delete(Node node) { // O(1)
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
