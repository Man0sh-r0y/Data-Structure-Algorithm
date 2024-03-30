import java.util.Arrays;
public class _27_PeakElementin2DArray {

    public static int[] findPeakElement(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        if(matrix[0][0] > matrix[0][1] && matrix[0][0] > matrix[1][0]) 
            return new int[]{0, 0};
        // if(matrix[0][col - 1] > matrix[0][col - 2] && matrix[0][col - 1] > matrix[1][col - 1])
        //     return matrix[0][col - 1];
        // if(matrix[row - 1][0] > matrix[row - 2][0] && matrix[row - 1][0] > matrix[row - 1][1])
        //     return matrix[row - 1][0];
        if(matrix[row - 1][col - 1] > matrix[row - 1][col - 2] && matrix[row - 1][col - 1] > matrix[row - 2][col - 1])
            return new int[]{row - 1, col - 1};

        int low = 1;
        int high = row * col - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / col, c = mid % col;
            int midElement = matrix[r][c];
            int prevElement = matrix[(mid - 1) / col][(mid - 1) % col];

            if(midElement > prevElement) {
                int nextElement = matrix[(mid + 1) / col][(mid + 1) % col];
                if(midElement > nextElement) 
                    return new int[]{r, c};
                else 
                    low = mid + 1;
            } 
            else 
                high = mid - 1;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 4},
            {3, 2}
        };

        System.out.println(Arrays.toString(findPeakElement(matrix)));
    }
}
