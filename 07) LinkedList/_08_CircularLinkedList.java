public class _08_CircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public static void addFast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public static void addAfterNode(int data, int nodeData) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        Node temp = head;
        do {
            if (temp.data == nodeData) {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println(nodeData + " not present in LinkedList");
    }

    public static void deleteFirst() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head == tail) {// only one node left in the whole linkedlist
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    public static void deleteLast() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head == tail) {// only one node left in the whole linkedlist
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = head;
    }

    public static void traverse() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        addFast(2);
        addFast(1);
        addFast(0);
        addLast(3);
        addLast(4);
        addLast(5);
        traverse();
        deleteFirst();
        deleteLast();
        traverse();
        addAfterNode(7, 3);
        traverse();
    }
}
