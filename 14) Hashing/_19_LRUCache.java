import java.util.HashMap;

public class _19_LRUCache {
    // LRU Cache => Least Recently Used Cache

    static class Node {// Creating Node class for making Doubly LinkedList
        int key;
        int data;// value of the Node
        Node prev;// doubly LinkedList
        Node next;// doubly LinkedList

        Node(int key, int data) {// Constructor
            this.key = key;
            this.data = data;
        }
    }

    static class LRUCache {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        HashMap<Integer, Node> map = new HashMap<>();// every key will be mapped with its Node
        int capacity;// size of the LRU Cache

        LRUCache(int capacity) {// Constructor of LRUCache class
            this.capacity = capacity;// defining size
            head.next = tail;// Doubly LinkedList
            tail.prev = head;// Doubly LinkedList
        }

        // Methods of LRU Cache
        public void insert(Node node) {
            map.put(node.key, node);
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            headNext.prev = node;
            node.next = headNext;
        }

        public void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.data;
            }
            return -1;
        }

        public void put(int key, int data) {
            if (map.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, data));
        }

        public void display() {
            if (head.next == tail) {
                System.out.println("LRU Cache is Empty");
                return;
            }

            Node temp = head.next;
            System.out.print("LRU Cache elements: ");
            while (temp != tail) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(5, 50);// key = 5, data = 50
        lru.put(3, 30);// key = 3, data = 30
        lru.put(1, 10);// key = 1, data = 10
        lru.display();

        System.out.println(lru.get(5));
        lru.display();

        lru.put(6, 60);// key = 6, data = 60
        lru.display();

    }
}