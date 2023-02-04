import java.util.*;

public class PractciseSet1 {
    public static void main(String args[]) {
        // Will the following statementgive any error in Java? => int$=24;
        int $ = 24;
        // In a program,input 3 numbers:A, B and C.You have to output the average of
        // these 3 number
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        Float Avg = (float) (A + B + C) / 3;
        System.out.println(Avg);

        // In a program,input the side of a square.You have to output the area of the
        // square.
        int side = sc.nextInt();
        int Area = side * side;
        System.out.println(Area);

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

    }

}
