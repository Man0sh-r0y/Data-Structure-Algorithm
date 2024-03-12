import java.util.Arrays;

public class _48_Merge2SortedArrays {

    public static void merge(long []a, long []b) {
        int left = a.length - 1, right = 0;

        while (left < a.length && right < b.length) {
            if(a[left] > b[right]) {
                // swap the left and right
                long temp = a[left];
                a[left] = b[right];
                b[right] = temp;
            }
            left--;
            right++;
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        long[] nums1 = {1,2,3};
        long[] nums2 = {2,5,6};
        merge(nums1,nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
