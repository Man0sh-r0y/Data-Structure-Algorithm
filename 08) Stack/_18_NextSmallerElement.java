import java.util.Arrays;
import java.util.Stack;

public class _18_NextSmallerElement {

    public static int[] prevSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        ans[0] = -1;
        s.push(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(s.peek() < arr[i]) {
                ans[i] = s.peek();
                s.push(arr[i]);
            }
            else {
                while(!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }

                if(s.isEmpty()) {
                    ans[i] = -1;
                    s.push(arr[i]);
                } 
                else {
                    ans[i] = s.peek();
                    s.push(arr[i]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prevSmaller(arr)));
    }
}
