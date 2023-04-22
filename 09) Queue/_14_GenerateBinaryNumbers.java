import java.util.*;

//Given a number N.
// The task is to generate and print all binary numbers with decimal values from 1 to N
public class _14_GenerateBinaryNumbers {

    public static Queue<Integer> reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;
    }

    public static Queue<Integer> getBinary(int num) {
        Queue<Integer> q = new LinkedList<>();
        while (num != 0) {
            q.add(num % 2);
            num /= 2;
        }
        return reverse(q);
    }

    public static void generateBinaryNumbers(int N) {
        Queue<Queue<Integer>> result = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            result.add(getBinary(i));
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        int N = 5;
        generateBinaryNumbers(N);
        // Ans: 1, 10, 11, 100, 101
    }
}
