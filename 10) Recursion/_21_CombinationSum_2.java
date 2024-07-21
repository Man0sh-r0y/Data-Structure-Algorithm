import java.util.*;

public class _21_CombinationSum_2 {
    public static void findCombinations(int indx, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(indx == arr.length) return;

        for(int i=indx; i<arr.length; i++) {
            if(i > indx && arr[i] == arr[i-1]) continue; // as we don't want the duplicates 

            if(arr[i] <= target) {
                ds.add(arr[i]); // adding array element
                findCombinations(i+1, arr, target-arr[i], ds, ans);
                ds.remove(ds.size()-1); // backtrack
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // tpo store all combinations
        List<Integer> ds = new ArrayList<>(); // a data structure to store each result
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ds, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1,1,2,2}, 4));
    }
}
