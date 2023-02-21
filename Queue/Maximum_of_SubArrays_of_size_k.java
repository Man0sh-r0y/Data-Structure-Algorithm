import java.util.Queue;
import java.util.LinkedList;

// We have an array arr[] of size N and an integer K.
// Find the maximum for each and every contiguous subarray of size K.

public class Maximum_of_SubArrays_of_size_k {

    public static Queue<Integer> findMax(int arr[], int N, int k) {
        Queue<Integer> q = new LinkedList<>();
        // we can see that for a array of size N,
        // the traversing is happening for N-k+1 times, where k is the size of subarray
        for (int i = 0; i < N - k + 1; i++) {
            q.add(Math.max(arr[i], Math.max(arr[i + 1], arr[i + 2])));
        }

        return q;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        int N = arr.length;
        System.out.println(findMax(arr, N, k));
    }
}
