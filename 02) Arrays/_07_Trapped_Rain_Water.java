
public class _07_Trapped_Rain_Water {

    // LOGIC:
    // 1. Water can't be trapped if:
    // 1.1. there is a single bar
    // 1.2. there are 2 bars
    // 1.3. there is only assceding or decending order of bars
    // 2. Water can be trapped between 2 boundaries
    // 3. Initialize an array (leftMax) to store the maximum height of the left boundary for each position.
    // 4. Initialize another array (rightMax) to store the maximum height of the right boundary for each position.
    // 5. The water level at each position will be the minimum of the leftMax and rightMax. (min(leftMax, rightMax))
    // 6. The water trapped at each position will be the difference between the water level and the height of the bar at that position. (min(leftMax, rightMax) - height[i])

    public static int trappedWater(int height[]) {
        int n = height.length;
        int leftMax[] = new int[n];// left boundary
        int rightMax[] = new int[n];// right boundary
        // left max boundary
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // right max boundary
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // trapped rain water
        int trappedRainWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedRainWater += waterLevel - height[i];
        }
        return trappedRainWater;
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedWater(height));
    }
}
