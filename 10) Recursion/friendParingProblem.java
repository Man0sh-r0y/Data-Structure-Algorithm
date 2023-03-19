import java.util.Scanner;

public class friendParingProblem {

    public static int friendParing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int fnm1 = friendParing(n - 1);
        int fnm2 = friendParing(n - 2);
        int totWays = fnm1 + (n - 1) * fnm2;
        return totWays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Friends: ");
        int n = sc.nextInt();
        System.out.println(friendParing(n));
        sc.close();
    }
}
