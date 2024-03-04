import java.util.Arrays;
import java.util.HashMap;
public class _28_TwoSum {

    // Approach 1: Using Hashing
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // the map is used to hash the current element and its index
        int[] ans = new int[2]; // to store both the index

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }

        return ans;
    }

    // Approach 2: Using Two Pointer (But here I'll not get actual indices as I'm sorting the Array, So index will be different than original array)
    public static int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2]; // to store both the index
        Arrays.sort(nums); // sorting the array
        int left = 0, right = nums.length - 1; // left pointer and right pointer

        while(left < right){
            if(nums[left] + nums[right] == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            } else if(nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSum2(arr, target)));
    }
}
