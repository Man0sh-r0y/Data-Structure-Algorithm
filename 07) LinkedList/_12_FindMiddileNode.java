public class _12_FindMiddileNode {

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

    public static ListNode findMiddleNode(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        ListNode temp = head;
        int len = 0; // length of linked list (Number of nodes)

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;

        for(int i = 0; i < len/2; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public static ListNode findMiddleNode2(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode createLL() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        return head;
    }

    public static void main(String[] args) {
        _12_FindMiddileNode obj = new _12_FindMiddileNode();
        ListNode head = obj.createLL();
        System.out.println(findMiddleNode(head).val);
    }
}
