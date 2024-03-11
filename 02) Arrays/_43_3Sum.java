import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _43_3Sum {

    // Brute force method
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.sort(null);
                        set.add(list);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    // Better Solution
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Map array elements with index
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                int third = 0 - (nums[i] + nums[j]);

                if(map.containsKey(third) && map.get(third) > j) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], third);
                    list.sort(null);
                    set.add(list);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    // Optimal Solution
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1, right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));// I got my ans
                    left++; // move the left pointer
                    right--; // move the right pointer
                    while(left < right && nums[left] == nums[left-1] && nums[right] == nums[right+1]){
                        // this means left and right are same as previous
                        // if I consider this again I'll have same list as previous
                        left++; // so incrementing the left pointer 
                        right--; // so decrementing the right pointer
                    }
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum3(nums));
    }
}
