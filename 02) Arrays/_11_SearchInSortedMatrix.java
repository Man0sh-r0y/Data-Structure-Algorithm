public class _11_SearchInSortedMatrix {

    public static void stairCaseSearch(int matrix[][], int element) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        boolean elementFound = false;

        while (col >= 0 && row < n) {
            if (element == matrix[row][col]) {
                System.out.println("Element Found at (" + row + "," + col + ") index");
                elementFound = true;
                break;
            }
            // go left
            else if (element < matrix[row][col]) col--;
            // go down
            else if (element > matrix[row][col]) row++;
        }
        
        if (!elementFound) System.out.println("Element not Found");
    }

    public static void main(String args[]) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int element = 33;
        stairCaseSearch(matrix, element);
    }
}
