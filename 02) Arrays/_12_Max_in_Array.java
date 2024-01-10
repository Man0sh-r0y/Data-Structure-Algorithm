import java.util.*;

public class _12_Max_in_Array {

    public static int findMax(int arr[]) {
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            MAX = Math.max(MAX, arr[i]);    
        return MAX;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum in Array is " + findMax(arr));
        sc.close();
    }
}
