public class _09_SpiralMatrix {

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