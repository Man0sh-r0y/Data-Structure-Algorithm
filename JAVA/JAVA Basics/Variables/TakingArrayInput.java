import java.util.*;

public class TakingArrayInput {

    public static void updateMarks(int Marks[]) {
        for (int i = 0; i < Marks.length; i++) {
            Marks[i] = Marks[i] + 1;
        }
    }

    public static void main(String args[]) {
        // Arrays
        int marks[] = new int[100];
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Phy Chem Math marks: ");
        marks[0] = sc.nextInt();// Phy
        marks[1] = sc.nextInt();// Chem
        marks[2] = sc.nextInt();// Math

        System.out.println("Phy Marks: " + marks[0]);
        System.out.println("Chem Marks: " + marks[1]);
        System.out.println("Math Marks: " + marks[2]);

        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("Percentage = " + percentage + " % ");

        System.out.println("Array Length is " + marks.length);

        // Passing Array as arguments
        int Marks[] = { 97, 98, 99 };
        updateMarks(Marks);
        for (int i = 0; i < Marks.length; i++) {
            System.out.print(Marks[i] + " ");
        }
        System.out.println();
    }
}