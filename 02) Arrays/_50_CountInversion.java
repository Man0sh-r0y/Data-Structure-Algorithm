public class _50_CountInversion {

    static class Inversion {
        static int count;
    }

    public static void mergeSort(int[]arr, int start, int end) {
        if(start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid); // divide the left part
        mergeSort(arr, mid + 1, end); // divide the right part
        merge(arr, start, mid, end); // sort and merge the left and right part
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start; // left will point the starting point of the left part of the array
        int right = mid + 1; // right will point the starting point of the right part of the array
        int i = 0; // it will point to the starting point of the temp array

        while(left <= mid && right <= end) {// Two Pointer approach 
            if(arr[left] <= arr[right]) {
                temp[i++] = arr[left++];
            } else {
                temp[i++] = arr[right++];
                Inversion.count += mid - left + 1;
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

    public static int countInversion(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

        return Inversion.count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 1, 4};
        System.out.println(countInversion(arr));
        // mergeSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
    }
}
