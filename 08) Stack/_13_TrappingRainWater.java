import java.util.*;

public class _13_TrappingRainWater {

    public static Stack<Integer> findLeftMax(int height[]) {
        Stack<Integer> s = new Stack<>();
        s.push(height[0]); // storing the 1st array element
        for (int i = 1; i < height.length; i++) {
            if (s.peek() >= height[i]) {
                s.push(s.peek());
                continue;
            }
            s.push(height[i]);
        }
        return s;
    }

    public static Stack<Integer> findRightMax(int height[]) {
        Stack<Integer> s = new Stack<>();
        int n = height.length; // storing the last array element
        s.push(height[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (s.peek() >= height[i]) {
                s.push(s.peek());
                continue;
            }
            s.push(height[i]);
        }
        // reverse the Stack
        Stack<Integer> rightMax = new Stack<>();
        for (int i = 0; !s.isEmpty(); i++) {
            rightMax.push(s.pop());
        }
        return rightMax;
    }

    public static int trappedWater(int height[]) {
        int trappedWater = 0;
        Stack<Integer> leftMax = findLeftMax(height);
        Stack<Integer> rightMax = findRightMax(height);
        // Trapped Rain Water Find
        for (int i = 0; i < height.length; i++) {
            // width = 1 so we just have to calculate height
            trappedWater += Math.min(leftMax.get(i), rightMax.get(i)) - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };
        System.out.println(trappedWater(height));
    }
}
