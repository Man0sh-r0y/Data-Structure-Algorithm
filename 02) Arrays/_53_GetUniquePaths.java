import java.util.ArrayList;

public class _53_GetUniquePaths {

    // Brute Force
    public static int uniquePaths(int m, int n) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for(int i=0; i<=m; i++) {
            dp.add(new ArrayList<>());

            for(int j=0; j<=n; j++) {
                dp.get(i).add(-1);
            }
        }

        //return findPaths(0, 0, m, n, dp); // initially the robot is at (0,0)
        return findPath(m, n);
    }

    public static int findPath(int row, int col, int m, int n) {
        if(row >= m || col >= n) // out of boundary
            return 0;

        if(row == m - 1 && col == n - 1)
            return 1; // reached the destination (bottom-right corner
        
        int downPaths = findPath(row + 1, col, m, n); // go down
        int rightPaths = findPath(row, col + 1, m, n); // go right

        int totalPaths = downPaths + rightPaths; // calculate total paths

        return totalPaths; // return total unique paths
    }

    public static int findPaths(int row, int col, int m, int n, ArrayList<ArrayList<Integer>> dp) {
        if(row >= m || col >= n) // out of boundary
            return 0;

        if(row == m - 1 && col == n - 1)
            return 1; // reached the destination (bottom-right corner
        
        if(dp.get(row).get(col) != -1)
            return dp.get(row).get(col);
        
        int downPaths = findPaths(row + 1, col, m, n, dp); // go down
        int rightPaths = findPaths(row, col + 1, m, n, dp); // go right
        
        int totalPaths = downPaths + rightPaths; // calculate total paths
        
        dp.get(row).set(col, totalPaths); // store the total unique paths 

        return totalPaths; // return total unique paths
    }

    public static int findPath(int m, int n) {
        int N = m + n - 2;
        int R = m - 1;
        double ans = 1.0;

        for(int i=1; i <= R; i++) {
            ans = ans * (N - R + i);
            ans = ans / i;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
