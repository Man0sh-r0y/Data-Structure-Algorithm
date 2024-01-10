import java.util.*;

public class _06_MaxSumSubArray {

    // LOGIC:
    // 1. Maximum sum from all the subarrays sum through Brute Force: O(n^3)
    // 2. I have to find the maximum sum from all the subarrays sum

    public static int maxSum(int arr[]) {// Brute Force
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) sum += arr[k];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // LOGIC
    // 1. Maximum sum through Prefix Sum algo: O(n^2)
    // 2. I have to find the maximum sum of all the subarrays
    // 3. Given Array: [1,-2,6,-1,3]
    // 4. Prefix Array: [1,-1,5,4,7] (In prefix array, we store the previous sum + current element)
    // 5. prefix array helps us to find the sum of any subarray in O(1) time
    // 6. At each index i, the value in the prefix sum array (prefix[i]) is the sum of all elements from index 0 to i in the original array.
    // 7. To find the sum of elements in a subarray from index i to j in the original array, you can utilize the prefix sum array.
    // 8. sum of subarray from index i to j = prefix[j] - prefix[i-1] (if i is greater than 0)
    // 9. If i=0, then sum of subarray from index i to j = prefix[j]
    

    public static int prefixSum(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];// curruent element + previous sum
        }
        int sum, maxSum = Integer.MIN_VALUE;

        // for each subarray, starting index is i and ending index is j
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == 0) 
                    sum = prefix[j];
                else 
                    sum = prefix[j] - prefix[i - 1];
                
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // LOGIC
    // 1. Maximum sum through Kadane's Rule: O(n)
    // 2. I have to find the maximum sum from all the subarrays sum
    // 3. Take a variable currSum (current sum)
    // 4. Run a loop and add each element to the current sum in every iteration
    // 5. in every step, if the current sum is negetive or not
    // 6. The subarray with negative sum is discarded
    // 7. in every iteration, we check if this is the max sum or not 
    // 4. We carry subarray till it gives positive sum.

    public static int kadanesRule(int arr[]) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        // Array input
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter Array Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    
        System.out.println("Maximum of SubArray through Brute Force method is " + maxSum(arr));
        System.out.println("Maximum of SubArray through Prefix Sum method is " + prefixSum(arr));
        System.out.println("Maximum of SubArray through Kadan's Rule method is " + kadanesRule(arr));
        sc.close();
    }
}
