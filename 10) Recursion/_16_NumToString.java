import java.util.Scanner;

public class _16_NumToString {

    public static void numToString(int n, String Digits[]) {
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        numToString(n / 10, Digits);
        System.out.print(Digits[lastDigit] + " ");
    }

    public static void main(String[] args) {
        String Digits[] = { "zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        numToString(n, Digits);
        sc.close();
    }
}
