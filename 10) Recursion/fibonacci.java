import java.util.*;

public class fibonacci {

    public static int getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fib1 = getFibonacci(n - 1);
        int fib2 = getFibonacci(n - 2);
        return fib1 + fib2;
    }

    // Another Method
    public static int n3, n2 = 1, n1 = 0;

    public static void fib(int n) {
        if (n == 0) {
            return;
        }
        fib(n - 1);
        n3 = n2 + n1;
        n1 = n2;
        n2 = n3;
        System.out.print(n3 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Range: ");
        int n = sc.nextInt();
        System.out.println(getFibonacci(n));
        fib(n);
        sc.close();
    }
}
