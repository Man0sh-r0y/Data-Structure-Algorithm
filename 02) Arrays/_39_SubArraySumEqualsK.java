
public class _39_SubArraySumEqualsK {

    // Brute Force Method
    public static int countSubArray(int[] arr, int k) {
        int count = 0; // count the subarray

        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum == k)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] nums2 = new int[]{1,-1,0};
        int k1 = 3;
        int k2 = 0;
        System.out.println(countSubArray(nums, k1));
        System.out.println(countSubArray(nums2, k2));
    }
}
