public class UnaryOperator {
    public static void main(String[] args) {
        // Unary Operator
        int p = 10;
        int q = ++p;
        System.out.println(p);// 11
        System.out.println(q);// 11

        p = 10;
        q = p++;
        System.out.println(p);// 11
        System.out.println(q);// 10

        p = 10;
        q = --p;
        System.out.println(p);// 9
        System.out.println(q);// 9

        p = 10;
        q = p--;
        System.out.println(p);// 9
        System.out.println(q);// 10
    }
}
