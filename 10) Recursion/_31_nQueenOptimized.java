import java.util.*;

public class _31_nQueenOptimized {

    public static void insertQueen(char board[][], int col, int n, boolean leftRow[], boolean upperDiagonal[], boolean lowerDiagonal[], List<List<String>> ans) {
        if (col == n) {
            printQueen(board, n);

            // print the output in given format (According to LeetCode)
            List<String> temp = new ArrayList<>();

            for(int i=0; i<board.length; i++) {
                String s = new String(board[i]);
                temp.add(s);
            }

            ans.add(temp);

            return;
        }

        for (int row = 0; row < n; row++) {
            if (!leftRow[row] && !upperDiagonal[n - 1 + col - row] && !lowerDiagonal[col + row]) {
                leftRow[row] = true;
                upperDiagonal[n - 1 + col - row] = true;
                lowerDiagonal[col + row] = true;

                board[row][col] = 'Q';
                insertQueen(board, col + 1, n, leftRow, upperDiagonal, lowerDiagonal, ans);
                // backtrack
                board[row][col] = '.';

                leftRow[row] = false;
                upperDiagonal[n - 1 + col - row] = false;
                lowerDiagonal[col + row] = false;
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
                board[i][j] = '.';
            }
        }

        boolean leftRow[] = new boolean[n];
        boolean upperDiagonal[] = new boolean[2 * n - 1];
        boolean lowerDiagonal[] = new boolean[2 * n - 1];

        List<List<String>> ans = new ArrayList<>();

        insertQueen(board, 0, n, leftRow, upperDiagonal, lowerDiagonal, ans);

        System.out.println(ans);
    }
}
