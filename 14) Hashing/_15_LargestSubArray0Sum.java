import java.util.HashMap;

public class _15_LargestSubArray0Sum {

    public static int lengthOfLargestSubArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // We will map sum with index: HashMap<Sum, index>
        int indx = -1;// initial index
        int sum = 0;// initially sum=0
        int maxLength = 0;
        while (++indx < arr.length) {
            sum += arr[indx];
            if (!map.containsKey(sum)) {
                map.put(sum, indx);
            } else {
                int length = indx - map.get(sum);
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Length of Largest SubArray => " + lengthOfLargestSubArray(arr));
    }
}
