public class _31_MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        boolean isAllNegative = true; // if all the numbers are negative in the array
        int sum = 0, maxSum = 0, largest = nums[0];
        // if all the numbers are negative in the array then return the largest number
        // otherwise find a subarray which has maximum sum

        for(int i=0; i<nums.length; i++) {
            // checking if the current number is -ve not not
            if(nums[i] >= 0) {
                isAllNegative = false;
            }
            // if negative then store largest number which is less negative
            if(isAllNegative) {
                largest = Math.max(largest, nums[i]);
            }
            // if isAllNegavtive becomes false, so there is also positive number, So no need to do above things
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {// subarray contains negative sum, so reset the sum to 0
                sum = 0;
            }
        }

        if(isAllNegative) {
            return largest;
        } else {
            return maxSum;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
