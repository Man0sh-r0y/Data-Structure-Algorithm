public class _31_MaximumSubArray {

    public static int maxSubArray(int[] nums) { // subarray which has maximum sum
        int sum = 0, maxSum = Integer.MIN_VALUE, largest = nums[0];
        // if all the numbers are negative in the array then return the largest number
        // otherwise find a subarray which has maximum sum

        for(int i=0; i<nums.length; i++) {
            largest = Math.max(largest, nums[i]);
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {// subarray contains negative sum, so reset the sum to 0
                sum = 0;
            }
        }

        if(maxSum < 0)
            maxSum = largest; 
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
