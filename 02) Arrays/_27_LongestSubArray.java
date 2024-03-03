public class _27_LongestSubArray {
    
    public static int longestSubArray(int[] arr, int k) {
        int left = 0, right = 0; // left pointer, right pointer
        // initially both pointers are at 0th index
        int maxLen = 0, len = 0;
        long sum = 0;
        
        while(right < arr.length) {
            sum += arr[right];

            while(left <= right && sum > k) {
                sum = sum - arr[left++];
            }

            if(sum == k) {
                len = right - left + 1; // calculate the length of the subarray that has sum = k
                maxLen = Math.max(maxLen, len);
            }

            right++; // increment the right pointer
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestSubArray(arr, k));
    }
}
