public class _11_SearchInSortedMatrix {

    // LOGIC:
    // Here I have to search for an element in a 2D matrix where each row and each column are sorted in ascending order.
    // In a sorted matrix, from top to bottom and left to right, the elements are sorted in ascending order.
    // Visualize the matrix as a staircase where you can start from the top-right corner or the bottom-left corner and navigate towards the element you're searching for.
    // Decide to start from the top-right corner (row = 0, col = m - 1). This position provides options to move both left and down.
    // Set up a loop that continues until you go out of bounds (either left or bottom).
    // At each step, compare the current element with the target element:
    // If the current element is equal to the target element, you found the element.
    // If the target element is smaller, move left (col--).
    // If the target element is larger, move down (row++).
    // If you go out of bounds, the element is not present in the matrix.
    // The approach is efficient because it takes advantage of the sorted nature of both rows and columns

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
