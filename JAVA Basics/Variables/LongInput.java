import java.util.Scanner;

public class LongInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        long a = sc.nextLong(); // taking input
        System.out.println(a);

        sc.close();
    }
}
