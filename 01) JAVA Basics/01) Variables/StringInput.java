import java.util.Scanner;

public class StringInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input : ");
        String str = sc.next(); // taking String input
        System.out.println(str);

        sc.nextLine();// to store '\n' from buffer memory after using sc.next()
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();// taking sentence input
        System.out.println(sentence);

        sc.close();
    }
}
