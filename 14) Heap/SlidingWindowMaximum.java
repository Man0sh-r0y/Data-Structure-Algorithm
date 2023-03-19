import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    static class Pair implements Comparable<Pair> {
        // pair in array value with their index
        int value;
        int indx;

        Pair(int value, int indx) {
            this.value = value;
            this.indx = indx;
        }

        @Override
        public int compareTo(Pair p) {
            // decending order
            return p.value - this.value;
            // comparing based on higher value of array element
        }
    }

    public static int[] slidingWindowMax(int[] arr, int k) {
        int result[] = new int[arr.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // store 1st k elements in PQ
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // storing 1st result
        result[0] = pq.peek().value;

        // PQ is the based on Max Heap. Priority of higher element value is more
        for (int i = k; i < arr.length; i++) {
            while (!pq.isEmpty() && pq.peek().indx <= (i - k)) {
                // If index of any element is less than or equal to (i-k)
                // then it's not in the current window
                pq.remove();// so we will remove that
            }
            pq.add(new Pair(arr[i], i));
            result[i - k + 1] = pq.peek().value;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3; // window length
        int[] ans = slidingWindowMax(arr, k);

        // printing the result
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
