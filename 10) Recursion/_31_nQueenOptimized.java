public class _31_nQueenOptimized {

    public static int n = 4;

    public static boolean leftRow[] = new boolean[n];
    public static boolean upperDiagonal[] = new boolean[2 * n - 1];
    public static boolean lowerDiagonal[] = new boolean[2 * n - 1];

    public static void insertQueen(char board[][], int col) {
        if (col == n) {
            printQueen(board);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!leftRow[row] && !upperDiagonal[n - 1 + col - row] && !lowerDiagonal[col + row]) {
                leftRow[row] = true;
                upperDiagonal[n - 1 + col - row] = true;
                lowerDiagonal[col + row] = true;

                board[row][col] = 'Q';
                insertQueen(board, col + 1);
                // backtrack
                board[row][col] = 'X';

                leftRow[row] = false;
                upperDiagonal[n - 1 + col - row] = false;
                lowerDiagonal[col + row] = false;
            }
        }
    }

    public static void printQueen(char board[][]) {
        System.out.println("---------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        insertQueen(board, 0);
    }
}
