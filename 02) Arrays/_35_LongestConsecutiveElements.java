import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _35_LongestConsecutiveElements {

    // Brute Force Solution
    public static int longestConsecutiveElements(int []arr) {// T.C = O(n^3)
        int maxLen = 0;
        for(int i=0; i<arr.length; i++) {
            int curr = arr[i], len = 1; // picking the current element and setting the length as 1
            while(true) {
                curr++; // as I want to check for next sequence so incrementing current element
                boolean isFound = false; // if I find the element in the array then I'll increment the length as I found the next sequence
                // Linear Search
                for(int j=0; j<arr.length; j++) {
                    if(arr[j] == curr) {// found the element
                        len++;
                        isFound = true;
                        break;
                    }
                }
                maxLen = Math.max(maxLen,len);
                if(!isFound)// if I can't find the element then the sequence break, So loop gets terminated
                    break;
            }
        }
        return maxLen;
    }

    // Better Solution
    public static int longestConsecutiveElements2(int []arr) {
        int len = 0, maxLen = 0, lastSmallest = Integer.MIN_VALUE;
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            if(arr[i] - 1 == lastSmallest){
                len++;// incrementing the length of the sequence
                lastSmallest = arr[i];
            } else if(arr[i] - 1 > lastSmallest) {
                len = 1;// starting a new sequence
                lastSmallest = arr[i];
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    // Optimal approach
    public static int longestConsecutiveElements3(int []arr) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<Integer>();

        // add all the elements in the set
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        for(int element: set) {
            int curr = element;
            if(set.contains(curr - 1)) // if current element - 1 is present in the set then it's not the starting point of the sequence 
                continue;
            // if (current element - 1) isn't present in the set then it's the starting point of the sequence
            int len = 0;
            while(set.contains(curr++)) // incrementing the current element and checking if it's present in the set
                len++;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 3, 8, 2};
        int[] arr2 = new int[]{100, 4, 200, 1, 3, 2};
        int[] arr3 = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveElements(arr));
        System.out.println(longestConsecutiveElements2(arr2));
        System.out.println(longestConsecutiveElements(arr3));
    }
}
