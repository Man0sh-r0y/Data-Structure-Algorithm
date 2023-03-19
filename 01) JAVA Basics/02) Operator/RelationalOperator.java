public class RelationalOperator {
    public static void main(String[] args) {
        // Relational Operator
        int A = 10;
        int B = 5;
        System.out.println(A == B); // false
        System.out.println(A != B); // true
        System.out.println(A > B); // true
        System.out.println(A < B); // false
        B = 10;
        System.out.println(A == B); // true
        System.out.println(A != B); // false
        System.out.println(A > B); // false
        System.out.println(A < B); // false
    }
}
