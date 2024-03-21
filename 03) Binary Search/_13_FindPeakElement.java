public class _13_FindPeakElement {

    public static int findPeak(int[] arr) {
        int indx = -1, n = arr.length ;

        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;

        int low = 1, high = n - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                indx = mid;
                break;
            }

            if(arr[mid] > arr[mid - 1]){// I'm in the left part
                low = mid + 1;
            }
            else {// I'm in the right part
                high = mid - 1;
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeak(arr));
    }
}
