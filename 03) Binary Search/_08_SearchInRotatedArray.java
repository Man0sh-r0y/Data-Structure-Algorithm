import java.util.Arrays;
public class _08_SearchInRotatedArray {

    public static int findMinElementIndx(int[] arr) {// find the index of smallest element
        int indx = 0; // initially minimum element is set to index 0

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(mid > 0 && arr[mid] < arr[mid - 1]) {// mid is the min element
                indx = mid;
                break;
            } 
            else {
                if(arr[low] <= arr[mid] && arr[mid] > arr[high]){
                    // here the left part is sorted. arr[high] is smaller than arr[mid]. So Search on the right part
                    low = mid +1;
                } else {
                    // here the right part is sorted. arr[low] is greater than arr[mid]. So Search on the left part
                    high = mid - 1;
                }
            }
        }

        return indx;
    }

    // O(2 * logn) approach [Search in Rotated Array (Array contains unique element)]
    public static int search(int[] arr, int target) {
        int indx;

        int min = findMinElementIndx(arr);

        if(target >= arr[min] && target <= arr[arr.length - 1]) {
            indx = Arrays.binarySearch(arr, min, arr.length, target); // search from min index to end index
        } else {
            indx = Arrays.binarySearch(arr, 0, min, target); // search from 0th indx to min index
        }

        return indx < 0 ? -1 : indx; // if index not found then return -1
    }

    // O(logn) approach [Search in Rotated Array (Array contains unique element)]
    public static int searchElement(int[] arr, int target) {
        int indx = -1;

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                indx = mid;
                break;
            }
            
            if(arr[low] <= arr[mid]) {// this means left part of the array is sorted
                if(arr[low] <= target && target <= arr[mid]) {// if target lies in the left part
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            else {// this means right part of the array is sorted
                if(arr[mid] <= target && target <= arr[high]) {// if target lies in the right part
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        int target = 2;
        System.out.println(search(arr, target));
        //System.out.println(findMinElementIndx(arr));
        System.out.println(searchElement(arr, target));
    }
}
