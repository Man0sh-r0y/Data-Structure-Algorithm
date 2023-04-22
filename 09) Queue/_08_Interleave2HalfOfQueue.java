import java.util.LinkedList;
import java.util.Queue;

public class _08_Interleave2HalfOfQueue {

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> fisrtHalf = new LinkedList<>();

        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            fisrtHalf.add(q.remove());
        }

        while (!fisrtHalf.isEmpty()) {
            q.add(fisrtHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Queue has to be of a even length
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        System.out.println(q);
        interLeave(q);
        System.out.println(q);
    }
}
