import java.util.PriorityQueue;

public class ConnectNropes {

    public static int findCostToConnectRopes(int[] ropes) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // copy array elements into PQ
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        while (pq.size() > 1) {// When there is 1 element in PQ, Loop willn't run
            int minElement1 = pq.remove();
            int minElement2 = pq.remove();// I have to pick 1st 2 element
            cost += minElement1 + minElement2;
            pq.add(minElement1 + minElement2);
        }

        return cost;
    }

    public static void main(String[] args) {
        int ropes[] = { 2, 3, 3, 4, 6 };
        System.out.println(findCostToConnectRopes(ropes));
    }
}
