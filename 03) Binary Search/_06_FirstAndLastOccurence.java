import java.util.Arrays;

public class _06_FirstAndLastOccurence {

    public static int firstOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int indx = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                indx = mid;
                high = mid - 1; // again try to find in the left part to get first occurence
            } else if(nums[mid] > target) {
                high = mid - 1;// search in the left part
            } else {
                low = mid + 1;// search in the right part
            }
        }

        return indx;
    }

    public static int lastOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int indx = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                indx = mid;
                low = mid + 1; // again try to find in the right part to get last occurence
            } else if(nums[mid] > target) {
                high = mid - 1;// search in the left part
            } else {
                low = mid + 1;// search in the right part
            }
        }

        return indx;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];

        range[0] = firstOccurence(nums, target);
        range[1] = lastOccurence(nums, target);

        return range;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
