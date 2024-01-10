public class _10_DiagonalSum {

    public static int diagonalSum(int matrix[][]) {
        int n = matrix.length, diagonalSum = 0;

        for(int i=0; i<n; i++)
            diagonalSum = matrix[i][i] + matrix[i][n-1-i]; // primaryDiagonalSum += matrix[i][i]; secondaryDiagonalSum += matrix[i][n-i-1];

        return (n%2 == 0) ? diagonalSum : diagonalSum - matrix[n/2][n/2];
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println("Diagonal Sum of the Matrix is " + diagonalSum(matrix));
    }
}
