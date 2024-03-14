public class _51_ReversePairs {

    public static void mergeSort(int[]arr, int start, int end, int[] count) {
        if(start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, count); // divide the left part
        mergeSort(arr, mid + 1, end, count); // divide the right part
        merge(arr, start, mid, end, count); // sort and merge the left and right part
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] count) {
        int[] temp = new int[end - start + 1];
        int left = start; // left will point the starting point of the left part of the array
        int right = mid + 1; // right will point the starting point of the right part of the array
        int i = 0; // it will point to the starting point of the temp array

        while(left <= mid && right <= end) {
            if((long)arr[left] > 2 * (long)arr[right]) {
                count[0] = count[0] + (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }

        left = start;
        right = mid + 1;

        while(left <= mid && right <= end) {// Two Pointer approach 
            if(arr[left] <= arr[right]) {
                temp[i++] = arr[left++];
            } else {
                temp[i++] = arr[right++];
            }
        }

        // if there are left elements in the left part of the array
        while(left <= mid) {
            temp[i++] = arr[left++];
        }

        // if there are left any elements in the right part of the array
        while(right <= end) {
            temp[i++] = arr[right++];
        }

        int j = start; 

        // Rewrite the original array with the merged and sorted elements
        for(i=0; i<temp.length; i++) {
            arr[j++] = temp[i];
        }
    }

    public static int reversePairs(int[] arr) {
        int[] count = new int[1];
        mergeSort(arr, 0, arr.length - 1, count);

        return count[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,5,1};
        System.out.println(reversePairs(arr));
    }
}
