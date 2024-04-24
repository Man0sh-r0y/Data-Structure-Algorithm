import java.util.Arrays;

public class _07_QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if(low <= high) {
            int partitionIndex = partitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex - 1); // Do same thing for left part of the partition index 
            quickSort(arr, partitionIndex + 1, high); // Do the same thing for the right part of the partition index
        }
    }

    public static int partitionIndex(int[] arr, int low, int high) {
        int pivot = arr[low]; // 1st element chosen as pivot element
        int i = low + 1; // array traversal will start from here
        int j = high;

        // the index i will point to the smaller elements than pivot 
        // and j will point to the greater elements than pivot

        while(i <= j) {
            while(i <= high && arr[i] <= pivot) i++; // checking if i is pointing the smaller elements
            while(j >= low + 1 && arr[j] > pivot) j--; // checking if j is pointing the larger elements

            // If I reach to a situation where i is pointing a larger element 
            // and j is pointing to a smaller element 
            // then swap the element

            if(i < j) swap(arr, i, j); // swap the position
        }

        // at the end, j will point to the smaller element as i > j (previous loop terminated)
        swap(arr, low, j); // place the pivot element in its correct place

        return j; // return the partition index (where pivot element is placed)
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}