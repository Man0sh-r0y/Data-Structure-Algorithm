import java.util.Stack;

public class _04_PushAtBottom {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int Top = s.pop();
        pushAtBottom(s, data);
        s.push(Top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        pushAtBottom(s, 1);
        pushAtBottom(s, 2);
        pushAtBottom(s, 3);
        pushAtBottom(s, 4);
        pushAtBottom(s, 5);
        System.out.println(s);
    }
}
