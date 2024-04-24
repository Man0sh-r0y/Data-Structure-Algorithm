import java.util.*;
public class _06_MergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int low, int high) {
        if (low >= high) 
            return;

        int mid = low + (high - low) / 2;// (low + high)/2
        mergeSort(arr, low, mid);// left part
        mergeSort(arr, mid + 1, high);// right part
        merge(arr, low, mid, high); // merge 
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int i = low;// iterator for left (left pointer)
        int j = mid + 1;// iterator for right (right pointer)
        int k = 0;// iterator for temp arrat

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) 
                temp[k++] = arr[i++];
            else 
                temp[k++] = arr[j++];
        }

        // if any elements still left in the left part of the array
        while (i <= mid) 
            temp[k++] = arr[i++];

        // if any elements still left in the right part of the array
        while (j <= high) 
            temp[k++] = arr[j++];
        
        // copy temp array to original array
        i = low; // reset the value
        k = 0; // reset the value
        while(k < temp.length) {
            arr[i++] = temp[k++];
        }
    }

    public static void main(String args[]) {
        int arr[] = new int[]{ 6, 3, 9, 5, 2, 8, -2 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}