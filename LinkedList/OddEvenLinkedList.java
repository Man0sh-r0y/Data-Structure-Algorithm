// We have a LinkedList of integers,write a function to modify the linkedlist such that all even numbers appear before all the odd numbers in the modified linkedlist. 
// Also,keep the order of even and odd numbers same

public class OddEvenLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node placeHeadNodeAtLast(Node head) {
        if (head.data % 2 == 0) {
            return head;
        }
        Node targetNode = head; // targetNode should have to be sent at the Last
        head = head.next; // head changed
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // plaching head node at the last
        temp.next = targetNode;
        targetNode.next = null;
        return placeHeadNodeAtLast(head);// if again head node's data is even
        // We have to run the code untill head's data getting even
    }

    public static Node placeNodeAtLast(Node node) {
        Node targetNode = node.next; // The node which I have to send it at the last
        node.next = targetNode.next; // break the linkage
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }
        // send it at the Last of the Likedlist
        temp.next = targetNode;
        targetNode.next = null;

        // return the node which was sent earlier
        return node;
    }

    public static boolean isEvenAvailable(Node node) {
        Node temp = node.next;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                return true; // the node whose data is even number is available
            }
            temp = temp.next;
        }
        return false; // the node whose data is even number isn't available
    }

    public static Node evenBeforeOdd(Node head) {

        if (head.data % 2 != 0 && isEvenAvailable(head)) {
            // if head's data is odd and there exist even nodes after the head node
            // replacing head node at the last
            head = placeHeadNodeAtLast(head); // untill head's data getting even
        }

        if (!isEvenAvailable(head)) {
            // if there doesn't exist any node whose data is even after the head node
            return head;
        }

        Node temp = head;
        while (temp != null) {
            if (!isEvenAvailable(temp)) {
                // if there doesn't exist any node whose data is even after the temp node
                break;
            } else if (temp.next != null && temp.next.data % 2 != 0) {
                placeNodeAtLast(temp);
            }
            temp = temp.next;
        }

        return head;
    }

    // printing linkedlist
    public static void printLinkedList(Node head) {
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
        // // node creation
        // Node first = new Node(8); // head
        // Node second = new Node(12);
        // Node third = new Node(10);
        // Node fourth = new Node(5);
        // Node fifth = new Node(4);
        // Node sixth = new Node(1);
        // Node seventh = new Node(6);

        // // Node linking
        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        // fifth.next = sixth;
        // sixth.next = seventh;

        // // Our linkedlist: 8->12->10->5->4->1->6->NULL
        // // Output should be: 8->12->10->4->6->5->1->null

        // printLinkedList(first);
        // evenBeforeOdd(first);
        // printLinkedList(first);

        // Another Example
        Node first = new Node(1); // head
        Node second = new Node(3);
        Node third = new Node(5);
        Node fourth = new Node(5);
        Node fifth = new Node(4);
        Node sixth = new Node(1);
        Node seventh = new Node(6);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        printLinkedList(first);
        first = evenBeforeOdd(first);
        printLinkedList(first);
    }
}
