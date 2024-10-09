import java.util.ArrayList;
import java.util.Collections;

public class _16_MergeKSortedArrays {

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(ArrayList<Integer> list: arr) 
            for(int nums: list) 
                ans.add(nums);
        
        Collections.sort(ans);

        return ans;
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        arr.add(new ArrayList<Integer>(){{
            add(3);
            add(5);
            add(9);
        }});

        arr.add(new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(8);
        }});

        System.out.println(mergeKSortedLists(arr));
    }
}