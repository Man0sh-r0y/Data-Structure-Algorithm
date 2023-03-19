import java.util.Scanner;

public class ShortInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        short a = sc.nextShort(); // taking input
        System.out.println(a);

        sc.close();
    }
}
