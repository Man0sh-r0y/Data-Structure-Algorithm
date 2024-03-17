public class _04_SearchInsertPosition {

    public static int searchInsertPos(int[] arr, int target) {
        int indx = arr.length;

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= target) {
                indx = Math.min(mid, indx);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        System.out.println(searchInsertPos(arr, 2));
    }
}
