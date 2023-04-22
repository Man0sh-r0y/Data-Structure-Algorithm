public class _10_IntersectionOf2LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getIntersectionPoint(Node head1, Node head2) {

        // for each node of 2nd linkedlist I am traversing the 1st likedlist
        // in which the 2nd linkedlist node has been intersected.

        for (Node i = head2; i != null; i = i.next) {
            for (Node j = head1; j != null; j = j.next) {
                if (i.next == j.next) {
                    return i.next;
                }
            }
        }

        return null; // not found.
    }

    public static void main(String[] args) {
        // node creation
        Node head1 = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(6);
        Node tail1 = new Node(7);
        Node head2 = new Node(4);
        Node tail2 = new Node(5);

        // Node linking
        head1.next = first;
        first.next = second;
        second.next = third;
        third.next = tail1;
        head2.next = tail2;

        // linkedlist intersection
        tail2.next = third;

        // printing the intersection node data
        System.out.println(getIntersectionPoint(head1, head2).data);
    }
}
