
public class _09_SpiralMatrix {

    // LOGIC:
    // The goal is to print the elements of a matrix in a spiral order, starting from the top-left corner and moving in a clockwise direction.
    // Take variables (startRow, startCol, endRow, endCol) to represent the current boundaries of the matrix to be printed.
    // Iterate through the matrix in a spiral order until all elements are printed.
    // For each side of the spiral (top, right, bottom, left), use separate loops to print the elements:
    // Print the top side from startCol to endCol.
    // Print the right side from startRow + 1 to endRow.
    // Print the bottom side from endCol - 1 to startCol (if there is more than one row).
    // Print the left side from endRow - 1 to startRow + 1 (if there is more than one column).
    // Ensure that the loops for printing the bottom and left sides check for the condition startRow != endRow or startCol != endCol 
    // So that it can avoid redundant printing in case there is only one row or one column remaining.
    // this senario can be happended when you have a matrix with dimensions 1xN (one row and multiple columns) or Nx1 (one column and multiple rows).
    // Without the check for redundancy, the algorithm might print the elements twice: 
    // once when printing the top side, and again when printing the bottom side (or similarly, for left and right sides).
    // continue the while loop until startRow <= endRow and startCol <= endCol.

    public static void printSpiralMatrix(int matrix[][]) {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;

        // printing spiral form of matrix[row][col]
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) 
                System.out.print(matrix[startRow][i] + " ");
            
            for (int j = startRow + 1; j <= endRow; j++) 
                System.out.print(matrix[j][endCol] + " ");
            
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow)  break;
                System.out.print(matrix[endRow][i] + " ");
            }
            for (int j = endRow - 1; j >= startRow + 1; j--) {
                if (startCol == endCol) break;
                System.out.print(matrix[j][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10, 11, 12 },
                           { 13, 14, 15, 16 } };
        printSpiralMatrix(matrix);
    }
}