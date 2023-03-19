public class TransposeOfMatrix {

    public static void transposeOfMatrix(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = arr[j][i];
            }
        }
    }

    public static void printArray(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Matrix before transpose: ");
        printArray(matrix);
        transposeOfMatrix(matrix);
        System.out.println("Matrix after transpose: ");
        printArray(matrix);
    }
}
