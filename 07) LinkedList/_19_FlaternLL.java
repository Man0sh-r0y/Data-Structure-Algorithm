import java.util.Comparator;
import java.util.PriorityQueue;

public class _19_FlaternLL {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    public static Node merge(Node l1, Node l2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                temp.bottom = l1;
                l1 = l1.bottom;
            }
            else {
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
            temp.next = null; // no horizontal reference should remian
        }

        // connecting the remaining list if any
        if(l1 != null) {
            temp.bottom = l1;
        }

        // connecting the remaining list if any
        if(l2 != null) {
            temp.bottom = l2;
        }

        return dummyNode.bottom;
    }
    
    Node flatten(Node root) {
        if(root == null ||root.next == null) return root;

        Node rootNext = flatten(root.next);
        Node mergedNode = merge(root, rootNext);

        return mergedNode;
    }
}
