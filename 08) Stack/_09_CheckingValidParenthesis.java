import java.util.*;

public class _09_CheckingValidParenthesis {

    public static boolean isMatch(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        } else if (a == '{' && b == '}') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }

    public static boolean isValid(Stack<Character> s, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                // when it's ')' , '}'. ']'
                char poppedElement = s.pop();
                if (!isMatch(poppedElement, str.charAt(i))) {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "({[]})";
        if (isValid(new Stack<>(), str)) {
            System.out.println("Parenthesis valid");
        } else {
            System.out.println("Parenthesis isn't valid");
        }
    }
}
