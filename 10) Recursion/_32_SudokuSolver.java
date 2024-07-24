public class _32_SudokuSolver {
    public static int k = 1;

    public static boolean solveSudoku(int sudoku[][], int row, int col) {
        if (row >= sudoku.length) {
            return true;
        }
        // System.out.println("row= " + row + " col= " + col); //for decode purpose I'll
        // use it

        if (col == sudoku[0].length) {
            return solveSudoku(sudoku, row + 1, 0);
        }

        if (sudoku[row][col] != 0) { // if not empty cell
            return solveSudoku(sudoku, row, col + 1); // checking for next column
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSudoku(sudoku, row, col + 1))
                    return true;
                // backtrack
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        for (int i = 0; i < 9; i++) { // as soduku board length is from 0 to 8 (row and column)
            // column checking
            if (sudoku[row][i] == digit)
                return false;
            // row checking
            if (sudoku[i][col] == digit)
                return false;
        }
        // grid checking
        int sr = (row / 3) * 3;// starting row
        int sc = (col / 3) * 3;// starting column
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        //         { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        //         { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        //         { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        //         { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        //         { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        //         { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        //         { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        //         { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };
        int[][] sudoku = new int[][] {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        

        if (solveSudoku(sudoku, 0, 0)) {
            printSudoku(sudoku);
        } else {
            System.out.println("No solution");
        }
    }
}
