public class BubbleSort {

    public static void Bubble_Sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int swap = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    swap = 1;
                }
            }
            if (swap == 0) {
                break;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 5, 4, 2, 3, 1 };
        Bubble_Sort(arr);
        printArray(arr);
    }
}
