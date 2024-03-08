
public class _37_FindPivotIndex {

    // Brute Force Approach
    public static int pivotIndex(int[] nums) {
        int indx = -1;

        for(int i=0; i<nums.length; i++) {
            int leftSum = 0, rightSum = 0, left = i-1, right = i+1;
            while(left >= 0) // checking the left part of the array
                leftSum += nums[left--];
            while(right < nums.length) // checking the right part of the array
                rightSum += nums[right++];
            if(leftSum == rightSum) {// checking if sum equals
                indx = i;// found pivot index
                break;
            }
        }

        return indx;
    }

    // Optimized Approach
    public static int pivotIndex2ndApproach(int[] nums) {
        int indx = -1, sumL = 0, sumR = 0;
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        leftSum[0] = 0; // as 0th index element doesn't have anything left to it
        rightSum[nums.length-1] = 0; // as (nums.length-1)th index element doesn't have anything right to it

        // counting the left sum
        for(int i=1; i<nums.length; i++) {
            sumL += nums[i-1];
            leftSum[i] = sumL;
        }

        // counting the right sum
        for(int i=nums.length-2; i>=0; i--) {
            sumR += nums[i+1];
            rightSum[i] = sumR;
        }

        // check at which index leftSum == rightSum
        for(int i=0; i<nums.length; i++) {
            if(leftSum[i] == rightSum[i]) {
                indx = i;
                break;
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex2ndApproach(nums));
    }
}