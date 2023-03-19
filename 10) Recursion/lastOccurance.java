public class lastOccurance {

    public static int LastOccurance(int arr[], int indx, int key) {
        if (indx == arr.length) {
            return -1;
        }
        int isFound = LastOccurance(arr, indx + 1, key);
        if (isFound == -1 && arr[indx] == key) {
            return indx;
        }
        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 1, 7, 5, 9, 8, 6, 5, 1 };
        System.out.println(LastOccurance(arr, 0, 1));
    }
}
