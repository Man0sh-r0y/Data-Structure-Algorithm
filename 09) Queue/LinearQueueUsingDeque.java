import java.util.Deque;
import java.util.LinkedList;

public class LinearQueueUsingDeque {

    public static Deque<Integer> q = new LinkedList<>();

    public static void add(int data) {
        q.addLast(data);
    }

    public static int remove() {
        return q.removeFirst();
    }

    public static int peek() {
        return q.getFirst();
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        System.out.println(q);
        remove();
        remove();
        System.out.println(q);
        System.out.println(peek());
    }
}
