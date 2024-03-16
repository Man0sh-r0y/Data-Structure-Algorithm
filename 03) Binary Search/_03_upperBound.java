public class _03_upperBound {

    public static int upperBound(int[] arr, int x) {
        int indx = arr.length;

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > x) {
                indx = Math.min(mid, indx);
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 8, 10};
        int x = 7;
        System.out.println(upperBound(arr, x));
    }
}
