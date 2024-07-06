import java.util.LinkedList;

public class _15_AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int carry = 0;
        ListNode temp = head;

        ListNode h1 = l1; // Head 1
        ListNode h2 = l2; // head 2

        while(h1 != null && h2 != null) {
            int sum = h1.val + h2.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);

            if(h1.next == null && h2.next == null && carry > 0) {
                temp = temp.next;
                temp.next = new ListNode(carry);
            }

            h1 = h1.next;
            h2 = h2.next;
            temp = temp.next;
        }

        while(h1 != null) {
            int sum = h1.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);

            if(h1.next == null && carry > 0) {
                temp = temp.next;
                temp.next = new ListNode(carry);
            }

            h1 = h1.next;
            temp = temp.next;
        }

        while(h2 != null) {
            int sum = h2.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);

            if(h2.next == null && carry > 0) {
                temp = temp.next;
                temp.next = new ListNode(carry);
            }

            h2 = h2.next;
            temp = temp.next;
        }

        return head.next;
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode head = addTwoNumbers(l1, l2);

        System.out.print("LinkedList 1: ");
        print(l1);
        System.out.print("LinkedList 2: ");
        print(l2);
        System.out.print("After Adding: ");
        print(head);
    }
}
