import java.util.Scanner;

public class ReverseOfNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
    }
}
