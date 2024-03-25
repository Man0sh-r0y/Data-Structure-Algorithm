import java.util.*;

public class _20_KthMissingPositivesInt {

    // Brute Force Approach
    public static int findKthPositive(int[] arr, int k) {
        int count = 0;

        Set<Integer> set = new HashSet<>();

        // put all the array elements into set 
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        // check if the element is missing
        for(int i=1; i<=2000; i++) { // As 1 <= k <= 2000
            if(!set.contains(i)) // check if the elemnt isn't present in the array
                count++;

            if(count == k) // return the kth missing number
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
}
