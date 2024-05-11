public class _14_RemobeNthNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { 
            this.val = val; 
        }

        ListNode(int val, ListNode next) { 
            this.val = val; this.next = next; 
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0; // size of the LinkedList

        while(temp != null) {
            size++;
            temp = temp.next;
        }
 
        temp = head;

        int nthNodeindx = size - n; // index of the node to be removed

        if(nthNodeindx == 0) {
            head = head.next;
            return head;
        } 

        for(int i=0; i<nthNodeindx-1; i++) {
            temp = temp.next;
        }
        
        // remove th Nth Node
        ListNode targetNode = temp.next; // the node which are supposed to be deleted
        temp.next = targetNode.next;
        targetNode.next = null;

        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for(int i=0; i<n; i++) 
            fast = fast.next;
        
        // now the fast pointer is n times ahead from the slow pointer
        // now start the journey
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.val == -1) { // that's mean I have to delete the head node
            head = head.next;
            return head;
        }

        // remove the node
        ListNode targetNode = slow.next; // the Node which are to be deleted
        slow.next = targetNode.next;
        targetNode.next = null;

        return head;
    }

    public ListNode createLL() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        // ListNode third = new ListNode(3);
        // ListNode fourth = new ListNode(4);
        // ListNode fifth = new ListNode(5);
        
        head.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        
        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }

        System.out.println("null"); 
    }

    public static void main(String[] args) {
        ListNode head = new _14_RemobeNthNode().createLL();
        print(removeNthFromEnd2(head, 1));
    }
}
