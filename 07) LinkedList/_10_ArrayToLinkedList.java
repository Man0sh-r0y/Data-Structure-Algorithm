public class _10_ArrayToLinkedList {

    class Node {
        int data;
        Node next;
   
        Node() {
            this.data = 0;
            this.next = null;
        }
   
        Node(int data){
            this.data = data;
            this.next = null;
        }
   
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public Node constructLL(int[] arr) {
        if(arr.length == 0) 
            return null;
        
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i=1; i<arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next; // temp = newNode
        }

        return head;
    }

    public void print(Node head) {
        if(head == null) 
            return;
        
        Node temp = head;

        while(temp!= null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        _10_ArrayToLinkedList ll = new _10_ArrayToLinkedList();

        Node head = ll.constructLL(arr);
        ll.print(head);
    }
}
