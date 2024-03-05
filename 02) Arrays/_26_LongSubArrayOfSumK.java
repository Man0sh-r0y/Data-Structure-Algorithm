import java.util.HashMap;
public class _26_LongSubArrayOfSumK {

    public static int longestSubArray(int[] arr, long k) { // array may contains  positives and negetives number both
        HashMap<Long, Integer> map = new HashMap<>(); // to store the current sum and its index until that point
        long sum = 0; // current sum
        int maxLen = 0, len = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i]; // current sum

            if(sum == k) {
                len = i+1; // if the sum is equal to k, then the length of the subarray is indx=0 to indx=i
                maxLen = Math.max(maxLen, len);
            }

            if(map.containsKey(sum - k)){
                len = i - map.get(sum - k); // if the current sum - k is present in the map, then the length of the subarray is indx=map.get(sum-k) to indx=i
                maxLen = Math.max(maxLen, len);
                map.put(sum, i); // map the current sum with its indx until that point
            } 

            if(!map.containsKey(sum)) { // if sum already present then don't map the sum
                map.put(sum, i); // map the current sum with its indx until that point
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestSubArray(arr, k));
    }
}
