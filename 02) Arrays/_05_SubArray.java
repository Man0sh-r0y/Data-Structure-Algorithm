public class _05_SubArray {

    // CODE Part:
    // 1. We have to print all the subarrays of the given array
    // 2. Run a outer loop from i=0 to i=n-1
    // 3. Run a inner loop inside i loop from j=i to j=n-1
    // 4. Run a inner loop inside the j loop from k=i to k=j

    // LOGIC:
    // Outer Iteration (i):
    // Start with the first element of the array as the initial index of the subarray.
    // Iterate through each subsequent element, considering it as the starting point of a subarray.
    
    // Middle Iteration (j):
    // For each chosen starting index from the outer iteration, iterate through the remaining elements in the array.
    // Consider each of these elements as the ending point of the subarray.

    // Inner Iteration (k):
    // For each combination of starting and ending indices determined by the outer and middle iterations, iterate through the elements in the subarray.
    // Print each element of the subarray.

    public static void printSubArrays(int arr[]) {
        // print all possible subarrays
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 5};
        printSubArrays(arr);
    }
}
