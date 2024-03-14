import java.util.Arrays;
public class _49_MissingAndRepeatingNum {

    // Optimal 1: Using Maths
    public static int[] findMissingRepeatingNumbers2(int []arr) {
        long n = arr.length;
        long sum = 0; // sum of all elements in the array
        long sumSquare = 0; // sum of squares of all elements in the array
        long SumN = n * (n + 1) / 2; // sum of all elements from 1 to n
        long SumSquareN = (n * (n + 1) * (2 * n + 1)) / 6; // sum of squares of all elements from 1 to n

        for(int i=0; i<n; i++) {
            sum += arr[i];
            sumSquare += (long)arr[i] * (long)arr[i];
        }

        long val1 = sum - SumN; // repeating number - missing number
        long val2 = (sumSquare - SumSquareN) / val1; // repeating number + missing number

        long repeatingNum = ((val1 + val2) / 2); // repeating number
        long missingNum = (val2 - repeatingNum); // missing number

        return new int[]{(int)repeatingNum, (int)missingNum};
    }

    // Optimal 2: Using Visited Method
    public static int[] findMissingRepeatingNumbers(int []arr) {
        int missingNum = -1, repeatingNum = -1;

        // Visited Method
        for(int i=0; i<arr.length; i++) {
            int index = Math.abs(arr[i]); // treat current elements as a index

            if(arr[index - 1] < 0) {
                repeatingNum = index;
            }

            if(arr[index - 1] > 0) {
                arr[index - 1] *= -1; // mark the element as negative
            }
        }

        // find missing number 
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) {
                missingNum = i + 1;
                break;
            }
        }

        return new int[]{repeatingNum, missingNum};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers2(arr)));
    }
}
