import java.util.*;

public class PracticeSetFunction {

    public static int average(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static boolean isEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }

    public static boolean isPalindrome(int number) {
        int myNum = number, lastDigit, reverse = 0;
        for (int i = 0; number != 0; i++) {
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }
        if (myNum == reverse) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumOfDigits(int number) {
        int i = 0, sum = 0, lastDigit;
        while (number != 0) {
            lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        return sum;
    }

    public static void main(String args[]) {

        // The average of three numbers
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Three Numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int avg = average(a, b, c);
        System.out.println("Average of " + a + "," + b + "," + c + " is " + avg);

        // Checking for even number
        System.out.print("Enter a Number: ");
        int num = sc.nextInt();
        if (isEven(num)) {
            System.out.println("The Number is Even");
        } else {
            System.out.println("The Number isn't Even");
        }

        // Checking for Palindrome
        System.out.print("Enter the Number: ");
        int myNum = sc.nextInt();
        if (isPalindrome(myNum)) {
            System.out.println(myNum + " is Palindrome");
        } else {
            System.out.println(myNum + " is not Palindrome");
        }

        // sum of the digits in an integer
        System.out.print("Enter an Integer: ");
        int number = sc.nextInt();
        System.out.println("Sum of Digits of " + number + " is " + sumOfDigits(number));
    }

}
