public class LogicalOperator {
    public static void main(String[] args) {
        // Logical Operator

        // Logical And
        System.out.println((3 > 2) && (5 > 0)); // true
        System.out.println((3 < 2) && (5 > 0)); // false

        // Logical Or
        System.out.println((3 < 2) || (5 > 0)); // true
        System.out.println((3 > 2) || (5 > 0)); // true

        // Logical Not
        System.out.println(!(2 < 5 && 2 < 10)); // false
    }
}
