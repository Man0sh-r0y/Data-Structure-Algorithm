public class _17_Palindrome {

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

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        // get the mid node
        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        System.out.println(slow.next.val);
        // when the loop will be terminated the slow node will be the mid node
        
        // check if palindrome
        while(slow != null) {
            if(temp.val != slow.val)
                return false;
            slow = slow.next;
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        
        System.out.println(isPalindrome(head));
    }
}
