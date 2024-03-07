import java.util.Arrays;

public class _33_NextPermutation {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int indx = -1;// index of the break point
        // find the breakpoint
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]){
                indx = i;
                break;
            }
        }

        // if no breakpoint found, reverse the whole array
        if(indx == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        // if found the brekpoint, find the next greater element
        for(int i=nums.length-1; i>indx; i--) {
            // find the greater element than nums[indx] but smaller in the right side of the array (from arr[indx+1] to arr[end])
            // swap the positions of nums[indx] and the greater element
            // reverse the right side of the array (from arr[indx+1] to arr[end])
            if(nums[i] > nums[indx]){
                swap(nums, i, indx);
                reverse(nums, indx+1, nums.length-1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
