public class _11_DeleteNnodesAfterMnodes {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node skipNodes(Node node, int M) {// skip M nodes
        Node temp = node;
        int i = 1;
        while (i < M) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public static Node delete(Node node, int N) {// Delete N nodes
        Node temp = node;
        int i = 0;
        while (i < N) {
            temp = temp.next;
            i++;
        }
        node.next = temp.next;// cutting the linkage of N nodes
        return node.next;
    }

    public static void modifyNodes(Node head, int M, int N) {
        Node temp = head;
        while (temp != null) {
            temp = skipNodes(temp, M);
            temp = delete(temp, N);
        }
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
        // node creation
        Node first = new Node(1); // head
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);
        Node eight = new Node(8);
        Node ninth = new Node(9);
        Node tenth = new Node(10);

        // Node linking
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eight;
        eight.next = ninth;
        ninth.next = tenth;

        int M = 3;
        int N = 2;
        // Delete N nodes after M nodes
        // our linkedlist: 1->2->3->4->5->6->7->8->9->10->null
        // output should be: 1->2->3->6->7->8->null

        modifyNodes(first, M, N);
        printLinkedList(first); // 1->2->3->6->7->8->null
    }
}
