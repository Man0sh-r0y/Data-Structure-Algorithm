public class _10_FindMinInRotatedArray {
    public static int findMin(int[] arr) {
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

        return arr[indx];
    }

    // Another Approach
    public static int findMinElement(int[] arr) {// array contains unique elements
        int minNum = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // if left part is sorted
            if(arr[low] <= arr[mid]){
                minNum = Math.min(minNum, arr[low]);
                low  = mid + 1;
            }
            // if right part is sorted 
            else {// arr[mid] <= arr[high] 
                minNum = Math.min(minNum, arr[mid]);
                high = mid - 1;
            }
        }

        return minNum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1,2};
        System.out.println(findMin(arr));
        System.out.println(findMinElement(arr));
    }
}
