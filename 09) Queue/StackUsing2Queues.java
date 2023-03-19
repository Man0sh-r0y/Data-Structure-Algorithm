import java.util.Queue;
import java.util.LinkedList;

public class StackUsing2Queues {

    public static Queue<Integer> q1 = new LinkedList<>();
    public static Queue<Integer> q2 = new LinkedList<>();

    public static boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void add(int element) {
        q1.add(element);
        System.out.println(element + " added");
    }

    public static void remove() {
        if (q1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q2.add(q1.remove());
        }

        System.out.println(q1.remove() + " deleted"); // removing the element

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    public static void display() {
        if (q1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(q1);
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        display();
        remove();
        remove();
        display();
        add(6);
        add(7);
        display();
        remove();
        remove();
        display();
    }
}
