import java.util.*;

public class _22_SubSetSum_1 {
    private static void findSubsetSums(int indx, ArrayList<Integer> arr, ArrayList<Integer> ans, int sum) {
        if(indx == arr.size()) {
            ans.add(sum);
            return;
        }
        
        findSubsetSums(indx + 1, arr, ans, sum + arr.get(indx));
        findSubsetSums(indx + 1, arr, ans, sum);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(0, arr, ans, 0);
        return ans;
    }

    private static void findSubsets(int indx, int[] nums, List<Integer> subsets, List<List<Integer>> ans) {
        if(indx == nums.length) {
            ans.add(new ArrayList<>(subsets));
            return;
        } 

        subsets.add(nums[indx]); // pick the element
        findSubsets(indx+1, nums, subsets, ans);
        subsets.remove(subsets.size()-1); // backtrack
        findSubsets(indx+1, nums, subsets, ans); // don't ;pick the element
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        findSubsets(0, nums, subsets, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subsetSums(new ArrayList<>(){
            {
                add(2);
                add(3);
            }
        }));

        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
