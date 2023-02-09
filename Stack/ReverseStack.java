import java.util.*;

public class ReverseStack {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int Top = s.pop();
        pushAtBottom(s, data);
        s.push(Top);
    }

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int Top = s.pop();
        reverse(s);
        pushAtBottom(s, Top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
