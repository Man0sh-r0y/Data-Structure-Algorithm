import java.util.ArrayList;
import java.util.List;

public class _34_SuperiorElements {

    public static List< Integer > superiorElements(int []arr) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[arr.length-1]); // as last element of the array always a superior element
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] > ans.get(ans.size()-1)){
                ans.add(arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3};
        System.out.println(superiorElements(arr));
    }
}
