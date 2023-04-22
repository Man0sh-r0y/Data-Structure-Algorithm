import java.util.*;

public class _11_Largest_Rectangle_in_Histogram {

    public static int[] nextLeftSmallest(int arr[]) {
        int nextLeft_smallest[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
                // if stack top becomes greater than array element then it's not the next left
                // smallest.
            }
            if (s.isEmpty()) {
                nextLeft_smallest[i] = -1;
                // when no there is no next left smallest
            } else {
                nextLeft_smallest[i] = s.peek();
                // stroing the index of the next left smallest element
            }
            s.push(i);
            // pushing the index of array element
        }
        return nextLeft_smallest;
    }

    public static int[] nextRightSmallest(int arr[]) {
        int nextRight_smallest[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
                // if stack top becomes greater than array element then it's not the next right
                // smallest.
            }
            if (s.isEmpty()) {
                nextRight_smallest[i] = arr.length;
                // when no there is no next right smallest, then the array length will be stored
                // (it will help to calculate the width)
            } else {
                nextRight_smallest[i] = s.peek();
                // stroing the index of the next right smallest element
            }
            s.push(i);
            // pushing the index of array element
        }
        return nextRight_smallest;
    }

    public static int findLargestRectangle(int arr[]) {
        int left[] = nextLeftSmallest(arr); // next left smallest
        int right[] = nextRightSmallest(arr); // next right smallest

        // calculate area of rectangle
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * (right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 2, 1, 5, 6, 2, 3 };
        int maxArea = findLargestRectangle(height);
        System.out.println("Area of Largest Rectangle is " + maxArea);
    }
}
