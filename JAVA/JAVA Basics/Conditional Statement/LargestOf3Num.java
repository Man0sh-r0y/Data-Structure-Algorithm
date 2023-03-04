public class LargestOf3Num {
    public static void main(String[] args) {
        // Largest of Three Number
        int X = 1;
        int Y = 2;
        int Z = 3;
        if (X >= Y && X >= Z) {
            System.out.println("X is Largest");
        } else if (Y >= X && Y >= Z) {
            System.out.println("Y is Largest");
        } else {
            System.out.println("Z is Largest");
        }
    }
}
