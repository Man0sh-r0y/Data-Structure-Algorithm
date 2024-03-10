import java.util.HashMap;
public class _42_CountSubArraysEqualsK {

    public static int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;// sum is for counting prefix sum and count is for counting the subarrays

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            
            if(sum == k)    
                count++;

            if(map.containsKey(sum - k)) 
                count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1); 
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 2, -3, 1, 4, 2};
        int k =7;
        System.out.println(subarraySum(arr, k));
    }
}
