import java.util.*;

// We have an integer k and a queue of integers,
// we need to reverse the order of the first k elements of the queue, leaving the other elements in the same relative order
public class Reversing_1st_K_Elements_in_Queue {

    public static void reverse(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();

        int size = q.size();
        // Atfirst we will remove the 1st k elements and will push it into stack
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        // Then we will add the stack elements into the queue
        // but those will be added from the rear part
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        // So We again have to remove the remaining 1st (size-k) elements and will add
        // to the queue for that, they will get back their own position
        // That's how we 1st k elemnts of queue will be reversed
        int i = 0;
        while (i < size - k) {
            q.add(q.remove());
            i++;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        System.out.println(q);
        int k = 5;
        reverse(q, k);
        System.out.println(q);
    }
}
