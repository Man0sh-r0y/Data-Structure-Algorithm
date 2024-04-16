public class _11_ArrayToDoublyLL {

    class Node {
        public int data;
        public Node next;
        public Node prev;
   
        Node()
        {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }
   
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
   
        Node(int data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public Node constructLL(int[] arr) {
        if(arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        head.prev = null;
        Node temp = head;

        for(int i=1; i<arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next; // move to that newNode (next)
        }

        return head;
    }

    public void print(Node head) {
        if(head == null) 
            return;
        
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        _11_ArrayToDoublyLL ll = new _11_ArrayToDoublyLL();
        Node head = ll.constructLL(arr);
        ll.print(head);
    }
}