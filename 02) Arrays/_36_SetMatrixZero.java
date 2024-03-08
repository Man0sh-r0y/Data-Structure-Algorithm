import java.util.ArrayList;
import java.util.Arrays;

public class _36_SetMatrixZero {

    public static void markRowCol(int[][] matrix, int i, int j) {
        for(int row=0, col=j; row<matrix.length; row++) // set the whole row to 0
            matrix[row][col] = 0;
        
        for(int row=i, col=0; col<matrix[row].length; col++) // set the whole column to 0
            matrix[row][col] = 0;
    }

    // Brute Force Solution
    public static void setMatrixZeroes(int[][] matrix) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();// to store indexes of zeros

        // storing the indexes of the zeros in the array
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    arr.add(new ArrayList<>());
                    arr.get(arr.size() - 1).add(i);
                    arr.get(arr.size() - 1).add(j);
                }
            }
        }

        for(int i=0; i<arr.size(); i++) {
            markRowCol(matrix, arr.get(i).get(0), arr.get(i).get(1));
        }
    }

    // Better Solution
    public static void setMatrixZeroes2(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {// if the element is zero then mark the row and column
                    rows[i] = 1; // marking that row as I have to mark all the elements as 0 in this row
                    cols[j] = 1; // marking that column as I have to mark all the elements as 0 in this column
                }
            }
        }

        for(int i=0; i<rows.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(rows[i] == 1 || cols[j] == 1) // if the row or column is marked then set the element to 0
                    matrix[i][j] = 0;
            }
            
        }
    }

    // Optimal Solution
    public static void setMatrixZeroes3(int[][] matrix) {
        boolean firstRowHasZero = false, firstColHasZero = false;
        
        // check if there is present zero in 1st column
        for(int row=0; row<matrix.length; row++) {
            if(matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // check if there is present zero in 1st row
        for(int col=0; col<matrix[0].length; col++) {
            if(matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Now I can use the 1st row and 1st column to mark the presence of zero in remaining row and columns 
        for(int row=1; row<matrix.length; row++) {
            for(int col=1; col<matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0; // mark this positions (inside 1st col) as 0
                    matrix[0][col] = 0; // mark this positions (inside 1st row) as 0
                }
            }
        }

        // Now setting the rows and columns to zero based on the 1st row and 1st column
        for(int row=1; row<matrix.length; row++) {
            for(int col=1; col<matrix[row].length; col++) {
                if(matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // setting the 1st row and 1st column to zero if they have zero
        if(firstRowHasZero){// if 1st row has zero then set the whole row to zero
            for(int col=0; col<matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        if(firstColHasZero){// if 1st column has zero then set the whole column to zero
            for(int row=0; row<matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        //setMatrixZeroes(matrix);
        //setMatrixZeroes2(matrix);
        setMatrixZeroes3(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
