public class fastOccurance {

    public static int FastOccurance(int arr[], int indx, int key) {
        if (indx == arr.length) {
            return -1;
        }
        if (arr[indx] == key) {
            return indx;
        }
        return FastOccurance(arr, indx + 1, key);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 1, 7, 5, 9, 8, 6, 5 };
        System.out.println(FastOccurance(arr, 0, 7));
    }
}
