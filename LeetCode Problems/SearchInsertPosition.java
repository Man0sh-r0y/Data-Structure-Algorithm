public class SearchInsertPosition {
    public static int searchPos(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        // if element not present in the array
        // then the starting indx of the target should be this: 'start'
        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 7;
        System.out.println(searchPos(nums, target));
    }
}
