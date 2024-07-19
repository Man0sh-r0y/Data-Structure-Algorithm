import java.util.*;

public class _23_SubSetSum_2 {
    static void printAns(List<String> ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(",", " "));
    }

    public static void findSubsets(int[] nums, int index, List<Integer> list, HashSet<String> set) {
        if (index == nums.length) {
            Collections.sort(list);
            set.add(list.toString());
            return;
        }
        list.add(nums[index]);
        findSubsets(nums, index + 1, list, set);
        list.remove(list.size() - 1);
        findSubsets(nums, index + 1, list, set);
    }

    public static List<String> subsetsWithoutDup(int[] nums) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        findSubsets(nums, 0, list, set);
        for (String it : set) {
            ans.add(it);
        }
        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 2 };
        //int[] nums = new int[]{1, 2, 2, 2, 3, 3};
        List<String> ans = subsetsWithoutDup(nums);
        printAns(ans);

        ArrayList<ArrayList<String>> ans2 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ans2.add(list2);
        ans2.add(list2);
        System.out.println(ans2);
        list2.add("2");
        System.out.println(ans2);

    }

}
