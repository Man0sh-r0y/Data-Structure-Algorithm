import java.util.Scanner;

public class PrimeNumChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prime Number Checking
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        if (isPrime == true) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }

        sc.close();
    }
}
