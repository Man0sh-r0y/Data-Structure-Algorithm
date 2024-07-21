import java.util.*;

public class _23_SubSetSum_2 {
    private static void findSubsets(int indx, int[] nums, List<Integer> subsets, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subsets));

        for(int i=indx; i<nums.length; i++) {
            if(i>indx && nums[i] == nums[i-1]) continue;
            System.out.println("indx = " + indx + " nums[indx] = " + nums[indx]);

            subsets.add(nums[i]); // pick the element
            findSubsets(i+1, nums, subsets, ans);
            subsets.remove(subsets.size()-1); // backtrack
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, subsets, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,1, 2, 2}));
    }

}
