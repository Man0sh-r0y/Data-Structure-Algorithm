import java.util.Scanner;

public class _01_linkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;

    public Node addFirst(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public Node addLast(Node head,int data) {
        if (head == null) {
            head.data = data;
            head.next = null;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.next = null;
        return head;
    }

    public Node deleteFirst(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty.");
            return null;
        }
        if (head.next == null) {
            head = null;
            return head;
        }
        head = head.next;
        return head;
    }

    public Node deleteLast() {
        if (head == null) {
            System.out.println("LinkedList is Empty.");
            return null;
        }
        if (head.next == null) {
            head = null;
            return head;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void printLinkedList() {
        if (head == null) {
            System.out.println("LinkedList is Empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        _01_linkedList ll = new _01_linkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your Choice:-");
            System.out.print(
                    "1: addFirst 2: addLast 3: deleteFirst 4: deleteLast 5: print LinkedList 6: reverse 7: Size  8: exit = ");
            int choice = sc.nextInt();
            int data;
            switch (choice) {
                case 1:
                    System.out.print("Enter the Data: ");
                    data = sc.nextInt();
                    head = ll.addFirst(data);
                    break;
                case 2:
                    System.out.print("Enter the Data: ");
                    data = sc.nextInt();
                    head = ll.addLast(data);
                    break;
                case 3:
                    head = ll.deleteFirst();
                    break;
                case 4:
                    head = ll.deleteLast();
                    break;
                case 5:
                    ll.printLinkedList();
                    break;
                case 6:
                    ll.reverse();
                    break;
                case 7:
                    System.out.println("Size of LinkedList is " + ll.getSize());
                    break;
                 case 8:
                     sc.close();
                     System.exit(0);
                     break;
                default:
                    System.out.println("Invaild Input");
                    break;
            }
        }
    }
}