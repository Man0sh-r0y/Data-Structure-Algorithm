import java.util.ArrayDeque;
import java.util.Deque;

public class _13_SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] result = new int[n - k + 1];

        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() <= (i - k)) {
                // If index of any element is less than or equal to (i-k)
                // then it's not in the current window
                q.remove();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && arr[q.peek()] < arr[i]) {
                q.remove();
            }
            // q contains index... result contains content
            q.add(i);// storing index
            if (i - k + 1 >= 0) {
                result[i - k + 1] = arr[q.peek()];// only one element left in q
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int ans[] = maxSlidingWindow(arr, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}