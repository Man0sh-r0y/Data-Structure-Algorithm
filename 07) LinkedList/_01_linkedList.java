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

        while (temp.next != null) 
            temp = temp.next;
        
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
    
        head = head.next;
        return head;
    }

    public Node deleteLast(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty.");
            return null;
        }

        if (head.next == null) {
            head = null;
            return head;
        }

        Node temp = head;

        while (temp.next.next != null) 
            temp = temp.next;
        
        temp.next = null;

        return head;
    }

    public int getSize(Node head) {
        if (head == null)
            return 0;

        int size = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        return size;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        
        // reverse the direction of the Next for each node
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev; // reverse the directionof the next

            prev = curr;
            curr = next;
        }

        head = prev; // when curr will be null, loop will be termintaed
        // then the prev will be the new head
        
        return head;
    }

    public void printLinkedList(Node head) {
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
        Node head = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter your Choice:-");
            System.out.print(
                    "\n 1: addFirst \n 2: addLast \n 3: deleteFirst \n 4: deleteLast \n 5: print LinkedList \n 6: reverse \n 7: Size \n 8: exit = ");
            int data, choice = sc.nextInt();
        
            switch (choice) {
                case 1:
                    System.out.print("\nEnter the Data: ");
                    data = sc.nextInt();
                    head = ll.addFirst(head, data);
                    break;
                case 2:
                    System.out.print("\nEnter the Data: ");
                    data = sc.nextInt();
                    head = ll.addLast(head, data);
                    break;
                case 3:
                    head = ll.deleteFirst(head);
                    break;
                case 4:
                    head = ll.deleteLast(head);
                    break;
                case 5:
                    ll.printLinkedList(head);
                    break;
                case 6:
                    head = ll.reverse(head);
                    break;
                case 7:
                    System.out.println("\nSize of LinkedList is " + ll.getSize(head));
                    break;
                 case 8:
                     sc.close();
                     System.exit(0);
                     break;
                default:
                    System.out.println("\nInvaild Input");
                    break;
            }
        }
    }
}