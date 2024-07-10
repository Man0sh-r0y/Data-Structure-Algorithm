public class _20_RotateList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode temp = head;
        ListNode tail = null;
        int len = 0;

        while(temp != null) {
            if(temp.next == null) tail = temp;
            temp = temp.next;
            len ++;
        }

        k = k % len;
        if(k == 0) return head; // no rotation required
        temp = head;

        for(int i=0; i<len-k-1; i++) temp = temp.next; // move to the kth node from the end

        tail.next = head; 
        head = temp.next; 
        temp.next = null; // break the list from kth node from the end

        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(rotateRight(head, 2));
    }
}
