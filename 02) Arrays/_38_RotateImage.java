import java.util.Arrays;

public class _38_RotateImage {

    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];

        // rotating the ans matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans[j][n-i-1] = matrix[i][j];
            }
        }

        // place elements in the original matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

    public static void transposeSwap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void reverseSwap(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n-j-1];
        matrix[i][n-j-1] = temp;
    }

    public static void rotateMatrix2(int[][] matrix){
        int n = matrix.length;
        // transpose the matrix
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                // swap the matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse the rows
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                // swap the first one with the last one and so on
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
