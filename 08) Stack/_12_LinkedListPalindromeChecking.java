import java.util.*;

public class _12_LinkedListPalindromeChecking {

    public static boolean isPalindrome(LinkedList<Character> ll) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < ll.size(); i++) {
            // pushing linkedlist content into stack
            s.push(ll.get(i));
        }

        // cheking palindrome or not
        for (int i = 0; i < ll.size(); i++) {
            if (s.pop() != ll.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('A');
        ll.add('B');
        ll.add('C');
        ll.add('B');
        ll.add('A');

        if (isPalindrome(ll)) {
            System.out.println("LinkedList is Palindrome");
        } else {
            System.out.println("LinkedList isn't Palindrome");
        }
    }
}
