public class _02_LowerBound {

    public static int lowerBound(int[] arr, int x) {
        int indx = arr.length;

        int low = 0, high = arr.length - 1;

        while(low <= high) { 
            int mid = low + (high - low) / 2;  
            if(arr[mid] >= x) {
                indx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 5};
        int x = 2;
        System.out.println(lowerBound(arr, x));
    }
}
