import java.util.*;

public class Max_in_Array {

    public static void arrayInput(int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    }

    public static int findMax(int arr[]) {
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (MAX < arr[i]) {
                MAX = arr[i];
            }
            // Another Way---->
            // MAX = Math.max(MAX, arr[i]);
        }
        return MAX;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        arrayInput(arr);
        System.out.println("Maximum in Array is " + findMax(arr));
    }
}
