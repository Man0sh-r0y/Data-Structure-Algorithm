public class _13_Search_in_RotatedArray {

    // LOGIC:
    // 1. I have to search the target element from a rotated sorted array
    // 2. Find that the minimum element in the rotated array indicates the pivot point.
    // 3. The pivot separates the array into two sorted subarrays
    // 4. Begin with a binary search approach to find the index of the minimum element (pivot) in the rotated array.
    // 5. This involves comparing midpoints to identify the unsorted portion where the pivot lies.
    // 6. Realize that once the pivot is found, the array can be treated as two sorted subarrays.
    // 7. Based on the target value, decide which of the two sorted subarrays to search
    // 8. If the target is within the range of the second subarray (right of the pivot), search there; otherwise, search in the first subarray (left of the pivot).
    // 9. Implement a binary search within the chosen subarray, similar to a regular binary search.
    // 10. Return the index of the target if found; otherwise, return -1.

    public static int searchInRotatedArray(int arr[], int target) {
        int min = findMinValueIndex(arr);
        
        if (target >= arr[min] && target <= arr[arr.length - 1]) 
            return binarySearch(arr, min, arr.length - 1, target); // search in left part array

        // if(arr[0] <= target && target <= arr[min])
        return binarySearch(arr, 0, min, target); // search in right part array
    }

    public static int binarySearch(int arr[], int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (target < arr[mid]) high = mid - 1;
            else if (target > arr[mid]) low = mid + 1;
        }
        return -1;
    }

    public static int findMinValueIndex(int arr[]) { // finding index of min element in sorted rotated Array
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid > 0 && arr[mid - 1] > arr[mid]) 
                return mid;
            else if (low <= arr[mid] && arr[mid] > arr[high]) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return low;
    }

    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 1;
        int targetIndex = searchInRotatedArray(arr, target);
        System.out.println("Target index is at " + targetIndex);
    }
}
