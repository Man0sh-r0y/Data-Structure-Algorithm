public class SumOfDigits {

    public static int sumOfDigits(int number) {
        int i = 0, sum = 0, lastDigit;
        while (number != 0) {
            lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(123));
    }
}
