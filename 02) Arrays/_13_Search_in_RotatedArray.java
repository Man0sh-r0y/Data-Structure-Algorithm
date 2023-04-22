public class _13_Search_in_RotatedArray {

    public static int search(int arr[], int target) {
        int min = minindex(arr);
        // search in left part array
        if (arr[min] <= target && target <= arr[arr.length - 1]) {
            return search(arr, min, arr.length - 1, target);
        }
        // search in right part array
        // if (arr[0] <= target && target <= arr[min]) {
        else {
            return search(arr, 0, min, target);
        }
    }

    public static int search(int arr[], int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    // index of min element in sorted rotated Array
    public static int minindex(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            } else if (low <= arr[mid] && arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }

    public static void main(String args[]) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 1;
        int targetIndex = search(arr, target);
        System.out.println("Target index is at " + targetIndex);
    }
}
