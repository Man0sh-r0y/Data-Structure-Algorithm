import java.util.Scanner;

public class FloatInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        float a = sc.nextFloat(); // taking input
        System.out.println(a);

        sc.close();
    }
}
