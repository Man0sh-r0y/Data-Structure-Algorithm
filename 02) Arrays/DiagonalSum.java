public class DiagonalSum {

    // 1st approach
    public static int diagonalSum(int matrix[][]) {
        int n = matrix.length;
        int primaryDiagonalSum = 0;
        // priomary diagonal Sum
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
        }
        int secondaryDiagonalSum = 0;
        // secondary diagonal Sum
        for (int i = 0, j = n - 1; j >= 0; i++, j--) {
            if (i == j) {
                continue;
            }
            secondaryDiagonalSum += matrix[i][j];
        }
        return primaryDiagonalSum + secondaryDiagonalSum;
    }

    // 2nd approach
    public static int diagonal_Sum(int matrix[][]) {
        int n = matrix.length;
        int diagonalSum = 0;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            int count = 0;
            if (count == 0 && i == j) {
                count = 1;
                continue;// this condition is applicable for only when n=Odd
            } else if (i + j == n - 1) {
                diagonalSum += matrix[i][i] + matrix[i][j];
            }
        }
        return diagonalSum;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println("Diagonal Sum of the Matrix is " + diagonalSum(matrix));
        System.out.println("Diagonal Sum of the Matrix is " + diagonal_Sum(matrix));
    }
}
