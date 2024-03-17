public class _07_CountOccurence {

    public static int firstOccurence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int indx = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                indx = mid;
                high = mid - 1; // again try to find in the left part to get first occurence
            } else if(arr[mid] > target) {
                high = mid - 1;// search in the left part
            } else {
                low = mid + 1;// search in the right part
            }
        }

        return indx;
    }

    public static int lastOccurence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int indx = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                indx = mid;
                low = mid + 1; // again try to find in the right part to get last occurence
            } else if(arr[mid] > target) {
                high = mid - 1;// search in the left part
            } else {
                low = mid + 1;// search in the right part
            }
        }

        return indx;
    }

    public static int count(int arr[], int x) {
        int fIndx = firstOccurence(arr, x); // first occurence index
        int lIndx = lastOccurence(arr, x); // last occurence index

        if(fIndx == -1)// if first occurence not found, then the element is not present in the array
            return 0;

        if(lIndx == -1) // if last occurence not found, then the element is present only once
            return 1;

        return lIndx - fIndx + 1; // return the count of the element
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 3};
        int x =3;
        System.out.println(count(arr, x));
    }
}
