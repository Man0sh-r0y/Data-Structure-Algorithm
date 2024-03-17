import java.util.Arrays;
public class _05_FloorAndCeil {

    public static int[] findFloorCeil(int[] arr, int x) {
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            } else if(arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 8, 8, 10};
        int x = 5;
        System.out.println(Arrays.toString(findFloorCeil(arr, x)));
    }
}
