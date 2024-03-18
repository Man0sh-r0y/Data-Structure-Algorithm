public class _09_SearchInRotatedArrayII {

    // Search in Rotated Array (Array contains Duplicate element)
    public static boolean search(int[] arr, int target) {
        int indx = -1;

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return true;
            }

            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue; // I may get same element again so continue to check it in next iteration
            }

            if(arr[mid] == target) {
                return true;
            }

            if(arr[low] <= arr[mid]) { // if left part is sorted
                if(arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if(arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));
    }
}
