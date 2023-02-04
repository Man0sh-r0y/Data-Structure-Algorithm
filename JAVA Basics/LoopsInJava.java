import java.util.*;

public class LoopsInJava {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // While Loop
        int counter = 0;
        while (counter < 10) {
            System.out.println("Hello World");
            counter++;
        }

        // print number from 1 to 10
        int number = 1;
        while (number <= 10) {
            System.out.println(number);
            number++;
        }

        // Sum of N Natural Number
        int sum = 0;
        number = 1;
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        while (number <= N) {
            sum += number;
            number++;
        }
        System.out.println("Sum of N natural number is " + sum);

        // print square patter
        System.out.print("Enter the number of Lines: ");
        int line = sc.nextInt();
        for (int i = 1; i < line; i++) {
            System.out.println("****");
        }

        // Print Reverse of a number
        int extractDigit;
        System.out.print("Enter a multidigit Number: ");
        int num = sc.nextInt();
        for (int i = 0; num != 0; i++) {
            extractDigit = num % 10;
            num /= 10;
            System.out.print(extractDigit);
        }

        // Reverse the given Number
        extractDigit = 0;
        int reverse = 0;
        System.out.print("\nEnter a multidigit Number: ");
        num = sc.nextInt();
        for (int i = 0; num != 0; i++) {
            extractDigit = num % 10;
            reverse = (reverse * 10) + extractDigit;
            num /= 10;
        }
        System.out.println(reverse);

        // Do While Loop
        int count = 1;
        do {
            System.out.println("Hello World");
            count++;
        } while (count <= 10);

        // break statement
        for (int i = 1; i <= 3; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("I'm out of the Loop.");

        // continue Statement
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }

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

    }
}
