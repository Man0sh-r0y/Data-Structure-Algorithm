import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _44_4Sum {

    // Optimal Approach
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1; j<nums.length; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = nums.length-1;

                while(left < right) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    System.out.println(sum);

                    if(sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1] && nums[right] == nums[right+1]) {
                            // that means that we got the same number as previous
                            // if I consider this I will get same ans list as previous
                            left++; // so move the left pointer 
                            right--; // so move the right pointer
                        }
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }
}
