public class _03_LinearQueueUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node front = null;
    public static Node rear = null;

    public static boolean isEmpty() {
        return front == null && rear == null;
    }

    public static void add(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
            System.out.println(rear.data + " added");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println(rear.data + " added");
    }

    public static void remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (front == rear) {// if there exist only one element
            System.out.println(front.data + " deleted");
            front = rear = null;
            return;
        }
        System.out.println(front.data + " deleted");
        front = front.next;
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        while (temp != rear) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data); // printing the rear element
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        display();
        remove();
        remove();
        display();
    }
}
