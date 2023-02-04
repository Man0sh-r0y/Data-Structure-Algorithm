import java.util.*;

public class operators {
    public static void main(String args[]) {
        // Arithmetic Operator
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("Add = " + (a + b));
        System.out.println("Substract = " + (a - b));
        System.out.println("Division = " + (a / b));
        System.out.println("Multiplication = " + (a * b));
        System.out.println("Modulo(%) = " + (a % b));

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

        // Logical Operator
        System.out.println((3 > 2) && (5 > 0)); // true
        System.out.println((3 < 2) && (5 > 0)); // false

        // Assignment Operator
        A = 10;
        A += 10;
        System.out.println(A);// 20
        A -= 10;
        System.out.println(A);// 10
        A *= 10;
        System.out.println(A);// 100
        A /= 10;
        System.out.println(A);// 10

    }
}