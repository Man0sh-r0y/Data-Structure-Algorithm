import java.util.*;

public class javaInput {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // String input
        String input = sc.next();// It will take single word String
        System.out.println("Inputed String is " + input);

        sc.nextLine();// to store '\n' from buffer memory
        String name = sc.nextLine();// It will take multiline word string
        System.out.println("Inputed String is " + name);

        // Sum of a & b
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println("Sum is " + (a + b));
        System.out.println("Product is " + (a * b));

        // radius of Circle
        float radius = sc.nextFloat();
        float PI = 3.14F;
        float Area = PI * radius * radius;
        System.out.println("The Area of Ciclr is " + Area);
    }

}
