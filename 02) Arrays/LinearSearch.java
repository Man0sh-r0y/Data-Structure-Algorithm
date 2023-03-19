import java.util.*;

public class LinearSearch {

    public static int linearSearch(int arr[], int searchElement) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element you want to search: ");
        int searchElement = sc.nextInt();
        int searchIndex = linearSearch(arr, searchElement);
        if (searchIndex == -1) {
            System.out.println("Element could not found");
        } else {
            System.out.println("Element found at index " + searchIndex);
        }
        sc.close();
    }
}