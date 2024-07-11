import java.util.HashMap;

public class _21_CopyList {

    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) { // O(N) Time Complexiety
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        Node newNode = new Node(head.val);

        map.put(head, newNode);
        map.put(null, null);

        while(temp != null) {
            if(!map.containsKey(temp.next)) {
                newNode.next = new Node(temp.next.val);
                map.put(temp.next, newNode.next);
            } else {
                newNode.next = map.get(temp.next);
            }

            if(!map.containsKey(temp.random)) {
                newNode.random = new Node(temp.random.val);
                map.put(temp.random, newNode.random);
            } else {
                newNode.random = map.get(temp.random);
            }

            newNode = newNode.next;
            temp = temp.next;
        }


        return map.get(head);
    }

    public static void print(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.next = null;
        head.next.random = head.next;

        print(copyRandomList(head));
            
    }   
}
