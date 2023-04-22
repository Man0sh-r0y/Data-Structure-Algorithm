import java.util.*;

public class _03_Binary_Search {

    public static void bubbleSort(int arr[]) {
        boolean preSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    preSorted = false;
                }
            }
            if (preSorted) {
                break;
            }
        }
    }

    public static int binarySearch(int arr[], int searchElement) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == searchElement) {
                return mid;
            } else if (searchElement < arr[mid]) {
                end = mid - 1;
            } else if (searchElement > arr[mid]) {
                start = mid + 1;
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
        bubbleSort(arr);
        System.out.print("Enter the element you want to search: ");
        int searchElement = sc.nextInt();
        int searchIndex = binarySearch(arr, searchElement);
        if (searchIndex == -1) {
            System.out.println("Element could not found");
        } else {
            System.out.println("Element found at index " + searchIndex);
        }
        sc.close();
    }
}
