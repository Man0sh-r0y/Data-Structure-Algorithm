import java.util.ArrayList;
import java.util.HashMap;

public class _17_TwoSum {

    public static ArrayList<Integer> twoSum(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // I'll map every element with their index

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        // finding two sum
        for (Integer element : map.keySet()) {
            if (map.get(target - element) != null) {
                ans.add(map.get(element));
                ans.add(map.get(target - element));
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 15, 2, 4, 16, 20, 1, 6, 7 };
        int target = 9;
        // I have to find the two index
        // in which the elements's sum of that two index is equal to target
        System.out.println("Index of the two elements whose sum is " + target + " is => " + twoSum(arr, target));
        System.out.printf("arr[%d] + arr[%d] = %d", twoSum(arr, target).get(0), twoSum(arr, target).get(1), target);
    }
}
