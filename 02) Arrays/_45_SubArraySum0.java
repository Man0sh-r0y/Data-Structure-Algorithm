import java.util.HashMap;

public class _45_SubArraySum0 {

    public static int getLongestZeroSumSubarrayLength(int []arr){
        int maxLen = 0,len, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();  

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if(sum == 0){
                len = i+1;
                maxLen = Math.max(maxLen, len);
            }

            if(map.containsKey(sum)){
                len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 1};
        System.out.println(getLongestZeroSumSubarrayLength(arr));
    }
}
