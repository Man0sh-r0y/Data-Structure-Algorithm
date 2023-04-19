import java.util.*;

public class _18_reverseStack {

    public static Stack<Integer> reverse(Stack<Integer> s, Stack<Integer> newS) {
        if (s.isEmpty())
            return newS;
        newS.push(s.pop());
        return reverse(s, newS);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        s = reverse(s, new Stack<>());
        System.out.println(s);

    }
}
