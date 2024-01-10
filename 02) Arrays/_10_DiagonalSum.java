public class _10_DiagonalSum {

    // LOGIC:
    // there are 2 diagonals in a matrix: primary diagonal and secondary diagonal
    // primary diagonal is from top left to bottom right
    // secondary diagonal is from top right to bottom left
    // I have to find the sum of both diagonals
    // The primary diagonal consists of elements with the same row and column indices (i, i).
    // The secondary diagonal consists of elements where the row and column indices sum up to (n - 1) for an n x n matrix. (rowIndex + columnIndex = n - 1)
    // If the matrix has an odd size (n is odd), the central element is part of both diagonals.
    // Subtract the central element from the overall sum to avoid double counting.

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
