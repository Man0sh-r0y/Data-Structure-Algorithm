import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _17_NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {// O(M + N)
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--) {
            map.put(nums2[i], i);
        }

        for(int i=0; i<nums1.length; i++) {
            int max = nums1[i];

            if(map.containsKey(nums1[i])) {

                for(int j=map.get(nums1[i]); j<nums2.length; j++) {

                    if(nums2[j] > max) {
                        ans[i] = nums2[j];
                        max = nums2[j];
                        break;
                    }
                }

                if(max == nums1[i]) 
                    ans[i] = -1;
            }
        }

        return ans;
    }

    public static int[] nextGreaterElementII(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        Stack<Integer> s = new Stack<>(); // monotonic stack
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(nums2[nums2.length-1], -1);
        s.push(nums2[nums2.length-1]);

        for(int i = nums2.length-2; i>=0; i--) {
            if(s.peek() > nums2[i]) {
                map.put(nums2[i], s.peek());
            }
            else {
                while(!s.isEmpty() && s.peek() < nums2[i])
                    s.pop();

                if(!s.isEmpty()) 
                    map.put(nums2[i], s.peek());
                else 
                    map.put(nums2[i], -1);
            }

            s.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        //System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElementII(nums1, nums2)));
    }
}