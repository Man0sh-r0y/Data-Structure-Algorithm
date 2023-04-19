import java.util.Scanner;

public class _03_naturalNumSum {

    public static int printInc(int n) {
        if (n == 1) {
            return n;
        }
        return n + printInc(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Range: ");
        int n = sc.nextInt();
        System.out.println(printInc(n));
        sc.close();
    }
}