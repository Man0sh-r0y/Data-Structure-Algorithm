import java.util.Scanner;

public class BooleanInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        boolean a = sc.nextBoolean(); // taking input
        System.out.println(a);

        sc.close();
    }
}
