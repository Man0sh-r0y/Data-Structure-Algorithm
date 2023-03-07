import java.util.Scanner;

public class ByteDataInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        byte a = sc.nextByte(); // taking input
        System.out.println(a);

        sc.close();
    }
}
