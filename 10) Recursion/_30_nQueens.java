public class _30_nQueens {
    // It's not optimized Code
    public static boolean isSafe(int row, int col, int n, char board[][]) {
        int dupRow = row;
        int dupCol = col;
        // diagonally up checking
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        // Left Checking
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }
        row = dupRow;
        col = dupCol;
        // diagonally down checking
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    public static void insertQueen(char board[][], int col, int n) {
        if (col == n) {
            printQueen(board, n);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                insertQueen(board, col + 1, n);
                // backtrack
                board[row][col] = 'X';
            }
        }
    }

    public static void printQueen(char board[][], int n) {
        System.out.println("---------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        insertQueen(board, 0, n);
    }
}