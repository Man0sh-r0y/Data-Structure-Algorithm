import java.util.Arrays;

public class _03_InsertionSort {

    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] >= curr) {// checking the right position for the element arr[i]
                arr[prev+1] = arr[prev]; // right shift 
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 5, 4, 1, 3, 2 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
