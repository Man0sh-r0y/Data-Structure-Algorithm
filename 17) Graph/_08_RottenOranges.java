import java.util.Queue;
import java.util.LinkedList;

public class _08_RottenOranges {

    static class Pair {
        int row, col, time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static boolean checkBoundaryCondition(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m; // if true then return true otherwise false
    }

    public static int rottenOranges(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int countFreshOranges = 0;
        int countRottenOranges = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 2) {
                    q.add(new Pair(row, col, 0));// inserted rotten oranges. (Initially it's 0th unit of time)
                    visited[row][col] = true;
                } else {
                    visited[row][col] = false;
                }

                if (grid[row][col] == 1)
                    countFreshOranges++;
            }
        }

        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };
        int minTime = 0;

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            minTime = Math.max(minTime, time); // in the inner loop time is incremented.
            // so max time is stored at this variable 'minTime'
            q.remove();

            for (int i = 0; i < 4; i++) {// as for each element in grid, I will go to 4 direction for its neighbours
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (checkBoundaryCondition(nRow, nCol, n, m) && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol, time + 1));// time is inremented
                    grid[nRow][nCol] = 2;// make fresh orange rotten
                    visited[nRow][nCol] = true;// visited
                    countRottenOranges++;
                }
            }
        }

        if (countFreshOranges != countRottenOranges)
            return -1;
        else
            return minTime;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 2 },
                { 0, 1, 1 },
                { 2, 1, 1 }
        };
        // 2: rotten orange
        // 1: fresh orange
        // 0: empty cell
        // rotten orange can rotten the fresh oragnge which are at horizontal and
        // vertical position (in 1 unit of time)
        // I will apply BFS approach
        int[][] newGrid = new int[grid.length][grid[0].length];
        // copy grid data to new grid as data is very important
        // whatever data is givven we should not tamper it
        // we will make copy of it and will work on it
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                newGrid[row][col] = grid[row][col];
            }
        }

        int ans = rottenOranges(newGrid);

        if (ans != -1)
            System.out.println(ans);
        else
            System.out.println("Couldn't rotten");

    }
}
