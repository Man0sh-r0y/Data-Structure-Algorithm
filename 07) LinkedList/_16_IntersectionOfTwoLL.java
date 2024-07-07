import java.util.HashSet;

public class _16_IntersectionOfTwoLL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Brute Force
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ansNode = null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null && tempB != null) {

            while (tempB != null) {
                if (tempA == tempB) {
                    ansNode = tempA;
                    return ansNode;
                }
                tempB = tempB.next;
            }

            tempA = tempA.next;
            tempB = headB;
        }

        ansNode = new ListNode(0);

        return ansNode;
    }

    // Better using HashSet: Time Complexiety: O(M+N) && Space Complexiety: O(M) or
    // O(N)
    public static ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode ansNode = null;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempB != null) {
            set.add(tempB);
            tempB = tempB.next;
        }

        while (tempA != null) {
            if (set.contains(tempA)) {
                ansNode = tempA;
                return ansNode;
            }
            tempA = tempA.next;
        }

        return ansNode;
    }

    // Another Aproach approach
    public static ListNode getIntersectionNodeIII(ListNode headA, ListNode headB) {
        ListNode ansNode = null;
        ListNode tempA = headA;
        ListNode tempB = headB;

        int lenA = 0, lenB = 0; // length of the linkedLists

        // calculate the length of two linkedList
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        // Get the difference between two LinkedList's length
        int diff = Math.abs(lenA - lenB);

        // Move the dummy pointer of the larger list by the difference achieved.
        if (lenA > lenB)
            while (diff-- > 0)
                tempA = tempA.next;
        else
            while (diff-- > 0)
                tempB = tempB.next;

        // then check for the intersection
        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                ansNode = tempA;
                return ansNode;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }

        return ansNode;
    }

    // Optimized
    public static ListNode getIntersectionNodeIV(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }

        return tempA;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(4);
        A.next = new ListNode(1);
        A.next.next = new ListNode(8);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ListNode B = new ListNode(5);
        B.next = new ListNode(6);
        B.next.next = new ListNode(1);
        B.next.next.next = A.next.next;
        B.next.next.next.next = A.next.next.next;
        B.next.next.next.next.next = A.next.next.next.next;

        System.out.println(getIntersectionNode(A, B).val);
        System.out.println(getIntersectionNodeII(A, B).val);
        System.out.println(getIntersectionNodeIII(A, B).val);
    }
}
