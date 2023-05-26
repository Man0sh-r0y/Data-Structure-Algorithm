import java.util.LinkedList;
import java.util.Queue;

public class _04_QueueUsingJavaCollection {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // or, Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);
        q.remove();
        q.remove();
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}
