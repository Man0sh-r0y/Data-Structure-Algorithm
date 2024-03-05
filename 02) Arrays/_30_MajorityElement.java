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

    // Approach 2: Moore's Voting Algorithm
    public static int majorityElement2(int[] nums) {
        int element = nums[0], count = 1; // element is initialized to nums[0] and count is incremented by 1

        // find the expected majority element
        for(int i=1; i<nums.length; i++) {
            if(count == 0){
                element = nums[i];
                count++;
            }
            else if(nums[i] == element) {
                count++;
            }
            else {
                count--;
            }
        }

        // if majority element is guaranteed to exist then the above loop is enough to reach the majority element, no needed to apply the below loop 

        int freq = 0; // count the frequency of the expected majority element

        // check if the expected majority element is the majority element
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == element) {
                freq++;
            }
        }

        return (freq > nums.length / 2) ? element : -1; // return the majority element if it exists, else return -1
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        System.out.println(majorityElement(arr));
    }
}
