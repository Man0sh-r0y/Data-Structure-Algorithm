public class _12_SingleElementInSortedArray {

    public static int findSingleElement(int[] arr) {
        int element = -1;
        
        if(arr.length == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];

        int low = 1, high = arr.length - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            // condition for the single element
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                element = arr[mid];
                break;
            }
            // figure out the left part
            if((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 != 0 && arr[mid] == arr[mid - 1])) {
                low = mid + 1; // if I am standing at the left part then go to the right
            } 
            else { // figure out the right part
                high = mid - 1; // if I am standing at the right part then go to the left
            }
        }

        return element;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(findSingleElement(arr));
    }
}
