public class _13_MergeTwoSortedeLL {

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

    public ListNode addLast(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        ListNode temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) { // O(n) space
        ListNode r = list1; // right pointer
        ListNode l = list2; // left pointer
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        if(list1 == null) {
            head = list2;
            return head;
        }
        
        if(list2 == null) {
            head = list1;
            return head;
        }

        while(r != null && l != null) {
            if(r.val < l.val) {
                ListNode newNode = new ListNode(r.val);
                temp.next = newNode;
                r = r.next;
            } else {
                ListNode newNode = new ListNode(l.val);
                temp.next = newNode;
                l = l.next;
            }
            temp = temp.next;
        }

        while(r != null) { // if still right LinkedList nodes are remaining
            ListNode newNode = new ListNode(r.val);
            temp.next = newNode;
            r = r.next;
            temp = temp.next;
        }

        while(l != null) { // if still left LinkedList nodes are remaining
            ListNode newNode = new ListNode(l.val);
            temp.next = newNode;
            l = l.next;
            temp = temp.next;
        }

        return head.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) { // O(n) space
        ListNode r = list1; // right pointer
        ListNode l = list2; // left pointer
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        if(list1 == null) {
            head = list2;
            return head;
        }

        if(list2 == null) {
            head = list1;
            return head;
        }

        while(r != null && l != null) { // merge two lists
            if(r.val < l.val) {
                temp.next = r;
                r = r.next;
            } else {
                temp.next = l;
                l = l.next;
            }
            temp = temp.next;
        }

        if(r != null) 
            temp.next = r;
        else 
            temp.next = l;

        return head.next; // head is -1, so return head.next
    }


    public static void print(ListNode head) {
        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }

        System.out.println("null"); 
    }

    public ListNode create1stLL() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(4);
        
        head.next = second;
        second.next = third;
        
        return head;
    }

    public ListNode create2ndLL() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        
        head.next = second;
        second.next = third;
        
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new _13_MergeTwoSortedeLL().create1stLL();
        ListNode list2 = new _13_MergeTwoSortedeLL().create2ndLL();

        print(mergeTwoLists2(list1, list2));
    }
}
