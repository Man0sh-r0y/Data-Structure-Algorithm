import java.util.*;

public class _02_ReverseArray {

    // LOGIC
    // 1. Run the loop from i=0 to i=n/2 in the array
    // 2. Swap the ith element with (n-1-i)th element 
    // 3. That means, swap the first element with the last element, second element with second last element and so on
    // 4. Time Complexity: O(n)

    public static void arrayInput(int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void ReverseArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        arrayInput(arr);
        ReverseArray(arr);
        printArray(arr);
        sc.close();
    }
}
