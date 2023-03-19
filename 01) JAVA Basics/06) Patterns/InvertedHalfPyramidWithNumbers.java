public class InvertedHalfPyramidWithNumbers {

    public static void Inverted_Half_Pyramid_with_Numbers(int n) {
        // 1 2 3 4 5 6
        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Inverted_Half_Pyramid_with_Numbers(6);
    }
}
