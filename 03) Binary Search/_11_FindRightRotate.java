public class _11_FindRightRotate {

    public static int findRightRotate(int[] arr) {
        int r = 0; // number of right rotations (move right elements towards right driection by `r` times)

        int low = 0, high = arr.length - 1;
        int maxNum = Integer.MIN_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[low] <= arr[mid]){// if left part is sorted
                maxNum = Math.max(maxNum, arr[mid]);
                if(maxNum == arr[mid]) r = mid; // store the index
                low = mid + 1;
            } 
            else {
                maxNum = Math.max(maxNum, arr[high]);
                if(maxNum == arr[high]) r = high; // store the index
                high = mid - 1;
            }
        }

        return r == arr.length - 1 ? 0 : (r - 0 + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(findRightRotate(arr));
    }
}
