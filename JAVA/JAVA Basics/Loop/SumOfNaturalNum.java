import java.util.Scanner;

public class SumOfNaturalNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sum of N Natural Number
        int sum = 0;
        int number = 1;
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        while (number <= N) {
            sum += number;
            number++;
        }
        System.out.println("Sum of N natural number is " + sum);
    }
}
