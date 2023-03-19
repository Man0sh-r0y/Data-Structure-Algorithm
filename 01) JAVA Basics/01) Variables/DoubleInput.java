import java.util.Scanner;

public class DoubleInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        double a = sc.nextDouble(); // taking input
        System.out.println(a);

        sc.close();
    }
}
