import java.util.LinkedList;
import java.util.Queue;

public class _06_NumberOfIslands {

    static class Pair {
        int row, col;

        Pair(int row, int col) {
            // This row , col together will determine the position into the 2D array
            this.row = row;
            this.col = col;
        }
    }

    public static int NumOfIslands(int[][] grid, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    BFS(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count; // number of islands
    }

    public static void BFS(int row, int col, int[][] grid, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;

        int n = grid.length; // total number of row
        int m = grid[0].length;// total number of column

        while (!q.isEmpty()) {
            int currRow = q.peek().row; // current row
            int currCol = q.peek().col; // curent col
            q.remove();
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = currRow + delRow; // nRow => Neighbour Row
                    int nCol = currCol + delCol; // nCol => Neighbour Column
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1
                            && !visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 1 } };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        System.out.println(NumOfIslands(grid, visited));
    }
}
