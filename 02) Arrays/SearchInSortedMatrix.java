public class SearchInSortedMatrix {

    public static void stairCaseSearch(int matrix[][], int element) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        boolean elementFound = false;
        while (j >= 0 && i < n) {
            if (element == matrix[i][j]) {
                System.out.println("Element Found at " + i + "," + j + " index");
                elementFound = true;
                break;
            }
            // go left
            else if (element < matrix[i][j]) {
                j--;
            }
            // go down
            else if (element > matrix[i][j]) {
                i++;
            }
        }
        if (!elementFound) {
            System.out.println("Element not Found");
        }
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
