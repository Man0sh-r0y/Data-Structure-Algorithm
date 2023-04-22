import java.util.PriorityQueue;

public class _01_AscendingOrderPriorityQueues {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();// Ascending Order Priority Queue
        pq.add(3);// O(logn) Time complexity
        pq.add(2);
        pq.add(5);
        pq.add(1);
        pq.add(4);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());// O(1) time cimplexity
            pq.remove();
        }

    }
}
