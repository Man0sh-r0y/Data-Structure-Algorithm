import java.util.Scanner;

public class ArithmeticOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Arithmetic Operator
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("Add = " + (a + b));
        System.out.println("Substract = " + (a - b));
        System.out.println("Division = " + (a / b));
        System.out.println("Multiplication = " + (a * b));
        System.out.println("Modulo(%) = " + (a % b));

        sc.close();

    }
}
