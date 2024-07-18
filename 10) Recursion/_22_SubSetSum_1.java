import java.util.*;

public class _22_SubSetSum_1 {
    static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset,
            ArrayList<Integer> list, HashSet<String> ans) {
        if (ind == N) {
            sumSubset.add(sum);
            ans.add(list.toString());
            return;
        }
        list.add(arr.get(ind));
        // pick the element
        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset, list, ans);

        list.remove(list.size() - 1);
        // Do-not pick the element
        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset, list, ans);
    }

    static void subsetSumHelper2(int ind, int sum, ArrayList<Integer> arr, ArrayList<Integer> sumSubset, ArrayList<Integer> list, HashSet<String> ans) {
        ans.add(list.toString());
        sumSubset.add(sum);

        for (int i = ind; i < arr.size(); i++) {
            list.add(arr.get(ind));
            subsetSumHelper2(ind + 1, sum + arr.get(ind), arr, sumSubset, list, ans);
            list.remove(list.size() - 1);
        }
    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {

        ArrayList<Integer> sumSubset = new ArrayList<>();
        HashSet<String> ans = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        //subsetSumsHelper(0, 0, arr, N, sumSubset, list, ans);
        subsetSumHelper2(0, 0, arr, sumSubset, list, ans);
        Collections.sort(sumSubset);
        System.out.println("Ans List: " + ans);
        return sumSubset;
    }

    public static void main(String args[]) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> ans = subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
