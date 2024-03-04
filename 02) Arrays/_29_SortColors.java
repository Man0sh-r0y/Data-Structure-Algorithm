import java.util.Arrays;
public class _29_SortColors {

    // Approach 1: Keeping count of values
    public static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0; // Counting the number of 0s, 1s, and 2s

        // Counting the number of 0s, 1s, and 2s
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count0++;
            } else if(nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // Placing the 0s, 1s, and 2s in the array
        for(int i=0; i<count0; i++) {
            nums[i] = 0;
        }
        for(int i=count0; i<count0+count1; i++) {
            nums[i] = 1;
        }
        for(int i=count0+count1; i<count0+count1+count2; i++) {
            nums[i] = 2;
        }
    }

    // Approach 2: Using Dutch National flag algorithm
    public static void sortColors2(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1; // low pointer, mid pointer, and high pointer

        while(mid <= high){
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0}; // We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
        int[] nums2 = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        sortColors2(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }
}
