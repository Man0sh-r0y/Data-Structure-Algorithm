import java.util.*;

public class _03_Binary_Search {

    // LOGIC
    // 1. Sort the array
    // 2. while sorting check if the array is already sorted
    // 3. Find the middle element of the array
    // 4. Compare the middle element with the search element
    // 5. If the search element is less than the middle element then search in the left half
    // 6. If the search element is greater than the middle element then search in the right half
    // 7. If the search element is equal to the middle element then return the index of the middle element
    // 8. If the search element is not found then return -1
    // 9. Repeat the steps 3 to 8 until the element is found or the start is less than or equal to the end

    public static void swap(int arr[], int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int arr[]) {
        boolean preSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    preSorted = false;
                }
            }
            if (preSorted) break;
        }
    }

    public static int binarySearch(int arr[], int searchElement) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == searchElement) return mid;
            else if (searchElement < arr[mid]) end = mid - 1;
            else if (searchElement > arr[mid]) start = mid + 1;
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
        bubbleSort(arr); // Sort the array
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        System.out.print("Enter the element you want to search: ");
        int searchElement = sc.nextInt();
        int searchIndex = binarySearch(arr, searchElement);

        if (searchIndex == -1)
            System.out.println("Element could not found");
        else
            System.out.println("Element found at index " + searchIndex);

        sc.close();
    }
}
