public class Factorial {

    public static int factorial(int num) {
        int f = 1, i = 1;
        while (i <= num) {
            f = f * i;
            i++;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
