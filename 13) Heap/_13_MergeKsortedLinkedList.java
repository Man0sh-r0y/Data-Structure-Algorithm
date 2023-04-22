import java.util.PriorityQueue;

// We have K sorted linked lists of size N each, merge them and print the sorted output.
public class _13_MergeKsortedLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeLinkedList(Node[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();// All the Node's data will be stored here
        // Storing all the Node's datas into PriorityQueue
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i].data);
                lists[i] = lists[i].next;
            }
        }

        Node head = new Node(-1);// new LinkedList creation
        // inistializing head of new LinkedList with -1
        // so LinkedList will start from head.next
        Node temp = head;
        while (!pq.isEmpty()) {
            temp.next = new Node(pq.remove());
            temp = temp.next;
        }
        return head.next;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        // LinkedList 1
        Node head1 = new Node(1);
        head1.next = new Node(5);
        head1.next.next = new Node(4);
        // LinkedList 2
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(6);
        // LinkedList 3
        Node head3 = new Node(7);
        head3.next = new Node(9);
        head3.next.next = new Node(8);
        // I have to merge k sorted LinkedList (here k=3)
        // The answear LinkedList should be in sorted order
        // Answear would be : 1->2->3->4->5->6->7->8->9
        int k = 3;// Number of the LinkedList
        Node[] lists = new Node[k];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;

        printLinkedList(mergeLinkedList(lists));
    }
}
