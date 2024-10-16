import java.util.Arrays;
import java.util.HashMap;

public class _17_NextGreaterElementI {

    static class Pair {
        int index;
        int nextGreater;

        Pair(int index, int nextGreater) {
            this.index = index;
            this.nextGreater = nextGreater;
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--) {
            
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}