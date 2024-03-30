import java.util.Arrays;
public class _26_Search2DMatrix {

    // method 1: (Staircase Search)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) 
                return true;
            else if(matrix[row][col] > target) 
                col --;
            else 
                row++;
        }

        return false;
    }

    // mehtod 2
    public static boolean searchMatrix2ndApproach(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) 
            if(matrix[i][0] <= target & target <= matrix[i][matrix[i].length - 1]) 
                return Arrays.binarySearch(matrix[i], target) >= 0;

        return false;
    }

    // method 3
    public static boolean searchMatrix3rdApproach(int[][] matrix, int target) {
        int n = matrix.length; // row number
        int m = matrix[0].length; // column number

        int low = 0;
        int high = n * m - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2; // index of mid element according to the falternate representation of 2d Matrix
            int row = mid / m; // row index of mid element
            int col = mid % m; // col index of mid element

            int midElement = matrix[row][col]; // mid element

            if(midElement == target) 
                return true;
            else if(midElement < target) 
                low = mid + 1;
            else 
                high = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix2ndApproach(matrix, 13));
        System.out.println(searchMatrix3rdApproach(matrix, 13));
    }
}
