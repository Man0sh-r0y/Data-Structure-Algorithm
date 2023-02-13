import java.util.*;

public class DuplicateParenthesis {

    public static boolean duplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // opening parenthesis
                s.push(str.charAt(i));
            } else if (str.charAt(i) == ')') { // closing parenthesis
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                // when there are duplicate parenthesis like ((a+b))
                // for inner parenthesis, when while loop will be terminated, count=3
                // but when the for loop will run for outer parenthesis and at the time when
                // while loop will be terminated count=0 (no cgange of value)
                if (count < 1) { // duplicate found
                    return true;
                } else {
                    s.pop(); // opening pair popped
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a + b)) + (((c + d)))";
        if (duplicateParenthesis(str)) {
            System.out.println("Duplicate Found");
        } else {
            System.out.println("Duplicate notFound");
        }
    }
}
