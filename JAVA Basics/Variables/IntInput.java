import java.util.Scanner;

public class IntInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        int a = sc.nextInt(); // taking input
        System.out.println(a);

        sc.close();
    }
}
