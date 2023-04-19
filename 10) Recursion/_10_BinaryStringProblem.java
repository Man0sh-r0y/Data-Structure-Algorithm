import java.util.Scanner;

public class _10_BinaryStringProblem {

    public static void binaryString(int n, int lastPlace, String newStr) {
        if (n == 0) {
            System.out.println(newStr);
            return;
        }
        binaryString(n - 1, 0, newStr + ("0"));
        if (lastPlace == 0) {
            binaryString(n - 1, 1, newStr + ("1"));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of String: ");
        int n = sc.nextInt();
        binaryString(n, 0, new String(" "));
        sc.close();
    }
}
