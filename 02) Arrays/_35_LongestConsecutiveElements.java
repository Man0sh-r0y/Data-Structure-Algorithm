
public class _35_LongestConsecutiveElements {

    // Brute Force Solution
    public static int longestSuccessiveElements(int []arr) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3 };
        System.out.println(longestSuccessiveElements(arr));
    }
}
