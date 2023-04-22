import java.util.Stack;

public class _05_QueueUsing2Stacks {

    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // adding element
    public static void add(int element) {
        s1.push(element);
        System.out.println(s1.peek() + " added");
    }

    // remove element
    public static void remove() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        System.out.println(s2.pop() + " deleted");// element removed

        while (!s2.isEmpty()) {
            s1.push(s2.pop()); // after deleting then again pushing other remaining elements
        }
    }

    // display elements
    public static void display() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(s1);
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        display();
        remove();
        remove();
        display();
        add(7);
        add(8);
        display();
    }
}
