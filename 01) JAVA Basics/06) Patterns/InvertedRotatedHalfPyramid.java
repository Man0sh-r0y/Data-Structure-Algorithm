public class InvertedRotatedHalfPyramid {

    public static void Inverted_Rotated_Half_Pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Inverted_Rotated_Half_Pyramid(5);
    }
}
