public class _07_FloodFillAlgo {

    public static boolean checkBoundaryCondition(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m; // if true then return true otherwise false
    }

    public static void dfs(int[][] grid, int row, int col, int newColor, int initialColor, int[] delRow, int[] delCol) {
        int n = grid.length;
        int m = grid[0].length;
        grid[row][col] = newColor;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (checkBoundaryCondition(nRow, nCol, n, m) && grid[nRow][nCol] == initialColor) {
                dfs(grid, nRow, nCol, newColor, initialColor, delRow, delCol);
            }
        }
    }

    public static void printGrid(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 1 },
                { 2, 2, 0 },
                { 2, 2, 2 }
        };

        int[] delRow = { -1, 0, +1, 0 };// change in row while moving to upper, right, bottom, left
        int[] delCol = { 0, +1, 0, -1 };// change in col while moving to upper, right, bottom, left

        // starting grid position = grid[2][0]
        dfs(grid, 2, 0, 3, 2, delRow, delCol);
        printGrid(grid);
    }
}
