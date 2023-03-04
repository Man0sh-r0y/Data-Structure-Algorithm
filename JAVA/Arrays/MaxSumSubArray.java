import java.util.*;

public class MaxSumSubArray {

    public static void printSubArrays(int arr[]) {
        // print subarrays
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.print("\b");
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static int maxSum(int arr[]) {// Brute Force
        int MAX_SUM = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                MAX_SUM = Math.max(MAX_SUM, sum);
            }
        }
        return MAX_SUM;
    }

    public static int prefixSum(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];// curruent element + previous sum
        }
        int MAX_SUM = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }
                MAX_SUM = Math.max(MAX_SUM, sum);
            }
        }
        return MAX_SUM;
    }

    public static int kadanesRule(int arr[]) {
        int currSum = 0;
        int MAX_SUM = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            MAX_SUM = Math.max(currSum, MAX_SUM);
        }
        return MAX_SUM;
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
        printSubArrays(arr);
        System.out.println("Maximum of SubArray is " + maxSum(arr));
        System.out.println("Maximum of SubArray is " + prefixSum(arr));
        System.out.println("Maximum of SubArray is " + kadanesRule(arr));
    }
}
