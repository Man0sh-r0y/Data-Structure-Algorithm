import java.util.*;

public class _08_FindNextGreater {

    public static void nextGreater(int arr[], int next_Greater[]) {
        // we will staart array traversing from last
        Stack<Integer> s = new Stack<>();
        for (int i = next_Greater.length - 1; i >= 0; i--) {
            // in stack we are pushing the index of the next greater element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                // if the stack top is lesser than current element then it's not the next
                // greater so it will be popped
                s.pop();
            }

            if (s.isEmpty()) {
                next_Greater[i] = -1;
                // for atmost right element next greater=0
                // and whenever stack is empty that's mean no next greater element present for
                // current element
            } else {
                next_Greater[i] = arr[s.peek()];
                // in stack we are pushing the index of the next greater element
            }
            // push the index of the array element
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int next_Greater[] = new int[arr.length];
        nextGreater(arr, next_Greater);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(next_Greater[i] + " ");
        }
        // 8 -1 1 3 -1 => ans
        System.out.println();
    }
}
