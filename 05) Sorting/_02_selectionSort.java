public class _02_selectionSort {

    public static void SelectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;// We assume our min index as current index
            for (int j = i + 1; j < n; j++) 
                if (arr[minIndex] > arr[j]) // finding the minimum element
                    minIndex = j; // store the minimum element's index
            
            if (minIndex != i) 
                swap (arr, i, minIndex);
        }
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 5, 4, 2, 3, 1 };
        SelectionSort(arr);
        printArray(arr);
    }
}
