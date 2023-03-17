public class HeapSort {

    // Heapify for max heap
    public static void heapify(int[] arr, int indx, int size) {// parameter has the index of the root element
        int leftChildIndx = 2 * indx + 1;
        int rightChildIndx = 2 * indx + 2;
        int maxIndx = indx; // assumimg that root has the maximum indx

        if (leftChildIndx < size && arr[maxIndx] < arr[leftChildIndx]) {
            // if the 'indx' is not the index of leaf element then only Loop will run as
            // leaf element has no child . If its not leaf element, then child element will
            // be present in the heap size range
            maxIndx = leftChildIndx;
            // whichever index element will be maximum that will be assigned into maxIndx
        }
        if (rightChildIndx < size && arr[maxIndx] < arr[rightChildIndx]) {
            // if the element has a right Child then only it will be true. For leaf element
            // it will be false.
            maxIndx = rightChildIndx;
            // whichever index element will be maximum that will be assigned into maxIndx
        }

        if (maxIndx != indx) {
            int temp = arr[indx];
            arr[indx] = arr[maxIndx];
            arr[maxIndx] = temp;

            heapify(arr, maxIndx, size);
        }
    }

    // O(nlogn) Time Complexity
    public static void heapSort(int[] arr) {// sort in ascending order
        int n = arr.length;
        // step-1: Build max heap Tree
        for (int i = n / 2; i >= 0; i--) {// last level se upar vale level se start hotahe iteration
            heapify(arr, i, n);
        }

        // step-2: push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap with largest-first with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);// heap size always decreasing as It's 'i' and index is always root index (=0)
        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 3, 1, 4 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
