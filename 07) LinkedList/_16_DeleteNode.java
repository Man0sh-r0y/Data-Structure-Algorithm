public class _16_DeleteNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Approach 1
    public static void deleteNode(ListNode node) {
        ListNode temp = node;

        while (temp.next.next != null) {
            temp.val = temp.next.val;
            temp = temp.next;
        }

        temp.val = temp.next.val;
        temp.next = null;
    }

    // Appropach II
    public static void deleteNodeII(ListNode node) {
        ListNode temp = node;

        temp.val = temp.next.val;
        temp.next = temp.next.next;
    }

    public static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);

        deleteNodeII(l.next.next);

        print(l);
    }
}
