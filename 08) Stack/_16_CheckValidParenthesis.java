import java.util.Stack;

public class _16_CheckValidParenthesis {

    public static boolean check(char parenthesis, char s) {
        if(parenthesis == ')' && s == '(')
            return true;
        else if(parenthesis == ']' && s == '[')
            return true;
        else if(parenthesis == '}' && s == '{')
            return true;
        else
            return false;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {

                if(stack.isEmpty() || !check(ch, stack.pop()))
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }

    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println(isValid(str)); // true
    }
}
