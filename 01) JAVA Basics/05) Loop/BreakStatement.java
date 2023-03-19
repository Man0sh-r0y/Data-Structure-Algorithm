public class BreakStatement {
    public static void main(String[] args) {
        // break statement
        for (int i = 1; i <= 3; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("I'm out of the Loop.");
    }
}
