import java.util.Arrays;

public class _04_MinSumAbsDiff {
    // Minimum sum of absolute difference of pairs of two arrays

    // Question: Given two arrays a[] and b[] of equal length n. The task is to pair
    // each element of array a to an element in array b, such that sum S of absolute
    // differences of all the pairs is minimum.

    // Approach:

    // Step 1: Sort both the arrays in O (n log n) time.

    // Step 2 : Find absolute difference of each pair of corresponding elements
    // (elements at same index) of both arrays and add the result to the sum S. The
    // time complexity of this step is O(n).

    public static int findMinSum(int[] a, int[] b) {
        // Sort both the arrays
        Arrays.sort(a);
        Arrays.sort(b);
        // find absolute difference
        int sum = 0;
        for (int i = 0; i < a.length; i++) {// length of both array is same
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        // Both a[] and b[] must be of same size.
        int[] a = { 3, 2, 1 };
        int[] b = { 2, 1, 3 };
        // Explanation :
        // 1st pairing: |3 - 2| + |2 - 1| + |1 - 3|
        // = 1 + 1 + 2 = 4
        // 2nd pairing: |3 - 2| + |1 - 1| + |2 - 3|
        // = 1 + 0 + 1 = 2
        // 3rd pairing: |2 - 2| + |3 - 1| + |1 - 3|
        // = 0 + 2 + 2 = 4
        // 4th pairing: |1 - 2| + |2 - 1| + |3 - 3|
        // = 1 + 1 + 0 = 2
        // 5th pairing: |2 - 2| + |1 - 1| + |3 - 3|
        // = 0 + 0 + 0 = 0
        // 6th pairing: |1 - 2| + |3 - 1| + |2 - 3|
        // = 1 + 2 + 1 = 4
        // Therefore, 5th pairing has minimum sum of
        // absolute difference.
        System.out.println(findMinSum(a, b));
    }
}