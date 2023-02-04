import java.util.*;

public class ifelseStatement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Age Checking
        int age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        } else if (age > 13 && age < 18) {
            System.out.println("Teeneger");
        } else {
            System.out.println("Not Adult");

        }

        // Largest of A & B
        int A = 1;
        int B = 5;
        if (A >= B) {
            System.out.println("A is the Largest.");
        } else {
            System.out.println("B is the Largest.");
        }

        // Find Even or Odd
        int number = 5;
        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        // Income Tax
        int income = 250000;
        int tax;
        if (income < 500000) {
            tax = 0;
        } else if (income >= 500000 && income < 1000000) {
            tax = (int) (income * 0.2);
        } else {
            tax = (int) (income * 0.3);
        }

        // Largest of Three Number
        int X = 1;
        int Y = 2;
        int Z = 3;
        if (X >= Y && X >= Z) {
            System.out.println("X is Largest");
        } else if (Y >= X && Y >= Z) {
            System.out.println("Y is Largest");
        } else {
            System.out.println("Z is Largest");
        }

        // Ternary Operator
        number = 4;
        String type = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(type);

        int marks = 67;
        String reportCard = (marks > 33) ? "Pass" : "Fail";
        System.out.println(reportCard);

        // Switch Statement
        number = 2;
        switch (number) {
            case 1:
                System.out.println("Burgur");
                break;
            case 2:
                System.out.println("Mango Shake");
                break;
            case 3:
                System.out.println("Samosa");
                break;
            default:
                System.out.println("Nothing");
        }

        // Making Calculator
        System.err.println("Enter the value of a and b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter the Operator: ");
        char operator = sc.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            case '%':
                System.out.println(a % b);
                break;
            default:
                System.out.println("Wrong Input");
        }

    }
}
