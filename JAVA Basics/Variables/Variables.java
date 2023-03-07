import java.util.*;

public class Variables {
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

        // Will the following statementgive any error in Java? => int$=24;
        int $ = 24;
        // In a program,input 3 numbers:A, B and C.You have to output the average of
        // these 3 number
        Scanner sc_ = new Scanner(System.in);
        int A = sc_.nextInt();
        int B = sc_.nextInt();
        int C = sc_.nextInt();
        Float Avg = (float) (A + B + C) / 3;
        System.out.println(Avg);

        // In a program,input the side of a square.You have to output the area of the
        // square.
        int side = sc.nextInt();
        int area = side * side;
        System.out.println(area);

        // Enter cost of 3 items from the user (using float data type)-a pencil,a pen
        // and an eraser.
        // You have to output the total cost of the items back to the user as their
        // bill.(Add on : You can also try adding 18% gst tax to the items in the bill
        // as an advanced problem)
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();
        float TotalCost = pen + pencil + eraser;
        float GST = TotalCost * 18 / 100;
        TotalCost = TotalCost + GST;
        System.out.println(TotalCost);

        sc.close();
        sc_.close();

    }

}
