import java.util.ArrayList;
import java.util.List;

public class _09_SpiralMatrix {

    public static List<Integer> printSpiralMatrix(int[][] matrix) {
        int top = 0; // top will point the first row of the matrix
        int bottom = matrix.length - 1; // bottom will point the last row of the matrix
        int left = 0; // left will point the first column of the matrix
        int right = matrix[0].length - 1; // right will point the last column of the matrix
        List<Integer> ansList = new ArrayList<>(); // here I'll store the spiral ordered element

        while(top <= bottom && left <= right) {
            // going from top left to top right
            if(top <= bottom) {
                for(int i=left; i<=right; i++) { // The loop itself is cheking if left <= right
                    ansList.add(matrix[top][i]);
                }
                top++; // top print done so top is incremented
            }
            // going from top right to bottom right
            if(left <= right) {
                for(int i=top; i<=bottom; i++) { // The loop itself is cheking if top <= bottom
                    ansList.add(matrix[i][right]);
                }
                right--; // right print done so right is decremented
            }
            if(top <= bottom) {
                // going from bottom right to bottom left
                for(int i=right; i>=left; i--) { // The loop itself is cheking if left <= right
                    ansList.add(matrix[bottom][i]);
                }
                bottom--; // bottom print done so bottom is decremented
            }
            if(left <= right) {
                // going from bottom left to top left
                for(int i=bottom; i>=top; i--) { // The loop itself is cheking if top <= bottom
                    ansList.add(matrix[i][left]);
                }
                left++; // left print done so left is incremented
            }
        }

        return ansList;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10, 11, 12 },
                           { 13, 14, 15, 16 } };
        System.out.println(printSpiralMatrix(matrix));
    }
}