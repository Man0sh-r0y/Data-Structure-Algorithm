import java.util.HashSet;

public class _18_StartingPointOfLoop {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Brute Force Approach
    public static ListNode detectCycle(ListNode head) { // O(N) Time Complexiety && O(N) Space Complexity
        if(head == null || head.next == null) return null;

        HashSet<ListNode> set = new HashSet<>();

        while(head != null) {
            if(set.contains(head)) return head;

            set.add(head);
            head = head.next;
        }

        return null;
    }

    public static ListNode detectCycleII(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null; // No Loop Found

        ListNode temp = head; // pointing to the head

        while(temp != slow) {
            temp = temp.next; // it's traversing from head to starting of the loop
            slow = slow.next; // it's traversing towards the starting point of the loop
        }

        return slow; // Starting Point of Loop
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode ans = detectCycleII(head);
        if(ans != null) System.out.println(ans.val);
        else System.out.println("No Loop Found");
    }
}
