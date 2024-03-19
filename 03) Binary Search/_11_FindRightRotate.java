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

    // another approach
    public static int numberOfRotations(int[] arr) {// array contains unique elements
        int minNum = Integer.MAX_VALUE, indx = 0; // minNum stores the minimum element in the array and indx stores the index of this minimum element
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // if left part is sorted
            if(arr[low] <= arr[mid]){
                minNum = Math.min(minNum, arr[low]);
                if(minNum == arr[low]) indx = low; // store the index
                low  = mid + 1;
            }
            // if right part is sorted 
            else {// arr[mid] <= arr[high] 
                minNum = Math.min(minNum, arr[mid]);
                if(minNum == arr[mid]) indx = mid; // store the index
                high = mid - 1;
            }
        }

        return (indx - 0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(findRightRotate(arr));
        System.out.println(numberOfRotations(arr));
    }
}
