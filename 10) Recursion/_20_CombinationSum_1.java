import java.util.*;

public class _20_CombinationSum_1 {
    // private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
    //     if (ind == arr.length) {
    //         if (target == 0) {
    //             ans.add(new ArrayList<>(ds));
    //         }
    //         return;
    //     }

    //     if (arr[ind] <= target) {
    //         ds.add(arr[ind]); // ds => a data structure (We took a data structure)
    //         findCombinations(ind, arr, target - arr[ind], ans, ds);
    //         ds.remove(ds.size() - 1);
    //     }
    //     findCombinations(ind + 1, arr, target, ans, ds);
    // }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(ind == arr.length) return;
       
        if(arr[ind] <= target) {
           ds.add(arr[ind]);
           findCombinations(ind, arr, target - arr[ind], ans, ds);
           ds.remove(ds.size() - 1);
       }
       findCombinations(ind+1, arr, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum(new int[]{2,3,5}, 8);

        System.out.println(ans);
    }
}
