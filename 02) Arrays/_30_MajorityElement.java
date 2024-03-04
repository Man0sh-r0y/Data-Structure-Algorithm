import java.util.HashMap;
public class _30_MajorityElement {

    // Approach 1: Using Hashing
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // the map is used to hash the current element and its frequency

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        for(int element : map.keySet()) {
            if(map.get(element) > nums.length / 2) {
                return element;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        System.out.println(majorityElement(arr));
    }
}
