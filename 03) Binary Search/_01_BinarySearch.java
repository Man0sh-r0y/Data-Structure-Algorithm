import java.util.Arrays;

public class _01_BinarySearch {

    // iterative method
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    // Recursive method
    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;

        if(low > high)
            return -1;

        if(arr[mid] == target) 
            return mid;

        if(arr[mid] < target) 
            return binarySearchRecursive(arr, mid + 1, high, target);
        else 
            return binarySearchRecursive(arr, low, mid - 1, target);
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Arrays.sort(arr);
        int target = 2;

        // Iterative Method
        if(binarySearch(arr, target) != -1)
            System.out.println("Element found");
        else
            System.out.println("Element not found");
        
        
        // Recursive Method
        if(binarySearchRecursive(arr, 0, arr.length - 1, target) != -1)
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }
}