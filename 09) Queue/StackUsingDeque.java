import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {

    public static Deque<Integer> q = new LinkedList<>();

    public static void push(int data) {
        q.addLast(data);
    }

    public static int pop() {
        return q.removeLast();
    }

    public static int peek() {
        return q.getLast();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println(q);
        pop();
        pop();
        System.out.println(q);
        System.out.println(peek());
    }
}
