import java.util.Arrays;
public class _32_RearrangeArrayElements {

    // Approach 1: Using temporary arrays
    public static int[] rearrangeArray(int[] nums) {// T.C = O(N + N/2), S.C = O(N/2 + N/2)
        int[] positives = new int[nums.length/2];
        int[] negatives = new int[nums.length/2];
        int j = 0, k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                negatives[j++] = nums[i];
            } else {
                positives[k++] = nums[i];
            }
        }
        // place the positives and negatives in original array in arranged order
        int indx = -1;
        for(int i=0; i<nums.length/2; i++){
            nums[++indx] = positives[i];
            nums[++indx] = negatives[i];
        }

        return nums;
    }

    // Approach 2: Optimal 
    public static int[] rearrangeArray2(int[] nums) {// T.C = O(N), S.C = O(N)
        int[] ans = new int[nums.length];
        int posIndx = 0, negIndx = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                ans[negIndx] = nums[i];
                negIndx += 2;
            } else {
                ans[posIndx] = nums[i];
                posIndx += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,-2,-5,2,-4};
        int[] arr2 = new int[]{3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
        System.out.println(Arrays.toString(rearrangeArray2(arr2)));
    }
}
