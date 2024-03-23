public class _18_SmallestDivisor {

    public static int findMinMax(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public static int checkSum(int[] nums, int divisor) {
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            int divison = Math.ceilDiv(nums[i], divisor);
            sum += divison;
        }

        return sum;
    }

    // Brute Force Approach
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = findMinMax(nums);

        for(int divisor=1; divisor<=max; divisor++) {
            int sum = checkSum(nums, divisor);
            if(sum <= threshold)
                return divisor;
        }

        return -1;
    }

    // Optimal Approach
    public static int smallestDivisor2ndApproach(int[] nums, int threshold) {
        int max = findMinMax(nums);
        int divisor = Integer.MAX_VALUE;

        int low = 1, high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int sum = checkSum(nums, mid);

            if(sum <= threshold) {
                divisor = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return divisor;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,9};
        int threshold = 6;
        int[] nums2 = new int[]{21212,10101,12121};
        int threshold2 = 1000000;
        System.out.println(smallestDivisor(nums, threshold));
        System.out.println(smallestDivisor(nums2, threshold2));
        System.out.println(smallestDivisor2ndApproach(nums2, threshold2));
    }
}
