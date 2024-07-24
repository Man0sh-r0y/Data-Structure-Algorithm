import java.util.Arrays;

public class _40_UniquePaths {

    public static int findPaths(int m, int n, int row, int col, int[][] dp) {
        if(row == m-1 && col == n-1) return 1;

        if(row >= m || col >= n) return 0;

        if(dp[row][col] != 0) return dp[row][col];

        int downPaths = findPaths(m, n, row+1, col, dp); // go to down
        int rightPaths = findPaths(m, n, row, col+1, dp); // go to right

        dp[row][col] = downPaths + rightPaths;

        return dp[row][col];
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // optimize this problem using DP
        for(int i=0; i<m; i++) Arrays.fill(dp[i], 0);

        return findPaths(m, n, 0, 0, dp);
    }

    public static void main(String[] args) {
        int m = 19;
        int n = 13;

        System.out.println(uniquePaths(m, n));
    }
}
