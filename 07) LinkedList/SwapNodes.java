// We have a linkedlist and two keys in it,swap nodes for two given keys

public class SwapNodes {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void swapNodes(Node head, int x, int y) {
        Node temp1 = head; // this pointer will search for the xth node
        Node temp2 = head; // this pointer will search for the yth node

        int i = 0;
        while (i < x - 2) {
            temp1 = temp1.next;
            i++;
        }

        int j = 0;
        while (j < y - 2) {
            temp2 = temp2.next;
            j++;
        }

        // swapping
        Node temp3 = temp1.next.next;
        Node temp4 = temp2.next.next;
        Node temp5 = temp1.next;

        temp1.next = temp2.next;
        temp1.next.next = temp3;

        temp2.next = temp5;
        temp2.next.next = temp4;
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
        // Node creation
        Node first = new Node(1); // head
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        // Node linking
        first.next = second;
        second.next = third;
        third.next = fourth;

        int x = 2;
        int y = 4;
        // I have to swap this 2 nodes (2nd node and 4th node)
        printLinkedList(first); // 1->2->3->4->null
        swapNodes(first, x, y);
        printLinkedList(first); // 1->4->3->2->null
    }
}
