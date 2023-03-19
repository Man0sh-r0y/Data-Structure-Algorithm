import java.util.Arrays;
import java.util.Collections;

public class inbuiltSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 5, 3, 4, 2, 1 };

        Arrays.sort(arr);
        printArray(arr);

        Integer numbers[] = { 1, 3, 4, 2, 5 };
        Arrays.sort(numbers, Collections.reverseOrder());
        printArray(numbers);

    }
}
