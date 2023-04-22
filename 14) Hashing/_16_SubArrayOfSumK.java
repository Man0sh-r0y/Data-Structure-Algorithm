import java.util.HashMap;

public class _16_SubArrayOfSumK {

    public static int numberOfSubArray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // I'll map the sum with its frequency HashMap<sum, Frquency of the
        // sum>
        // Frquency means how many time it has already came
        int sum = 0;
        int freq = 1;
        // we can assume that Sum=0 has came 1 times (as initially sum
        // variable=0)
        map.put(sum, freq);// Sum=0 came 1 time
        int NumberOfSubArray = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // We are finding a subArray of Sum k
            // we got a subarray of Sum x
            // suppose previously we got subarray of Sum x-k
            // so between them we got subarray of Sum (x-(x-k))=k
            if (map.containsKey(sum - k)) {
                // ( sum - k ) denotes the sum of previoulsy gotten subarray
                // so how many times I'll get (sum - k),
                // that is the freuency of getting subarray of sum k
                NumberOfSubArray += map.get(sum - k);
            } else {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                // if sum is present then its frequerncy will be increased by 1
                // otherwise default value = 0 will be there with inremented by 1
            }
        }

        return NumberOfSubArray;

    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, -2, -20, 10 };
        int k = -10;
        // I have to find a subArray whose sum is -10
        System.out.println("Numver of SubArray whose sum is " + k + " is => " + numberOfSubArray(arr, k));
    }
}
