public class IsEvenOrNot {

    public static boolean isEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }

    public static void main(String[] args) {
        System.out.println(isEven(2));
    }
}
