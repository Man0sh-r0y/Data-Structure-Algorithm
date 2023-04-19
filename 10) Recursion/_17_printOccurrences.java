public class _17_printOccurrences {
    // Practice set Question 1
    public static void PrintOccurrences(int arr[], int indx, int key) {
        if (indx == arr.length) {
            return;
        }
        if (arr[indx] == key) {
            System.out.print(indx + " ");
        }
        PrintOccurrences(arr, indx + 1, key);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;
        PrintOccurrences(arr, 0, key);
    }
}
