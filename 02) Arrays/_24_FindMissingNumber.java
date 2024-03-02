public class _24_FindMissingNumber {

    // Approach 1
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n*(n+1)/2; // sum of n natural numbers
        int sum = 0; // if will store the sum of the array elements
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        return totalSum - sum; // difference will be the missing number
    }

    // Approach 2
    public static int missingNumber2ndApproach(int[] nums) {
        int xor1 = 0, xor2 = 0; 

        for(int i=0; i<nums.length; i++) {
            xor1 ^= nums[i]; // XOR of all the elements of the array
            xor2 ^= i; // XOR of all the elements from 0 to n-1
        }
        xor2 ^= nums.length; // XOR of all the elements from 0 to n (as loop was running till n-1, so we need to XOR with n as well)

        return xor1 ^ xor2; // XOR of both the XORs will be the missing number
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber2ndApproach(arr));
    }
}
