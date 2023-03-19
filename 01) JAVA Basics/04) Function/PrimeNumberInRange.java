public class PrimeNumberInRange {

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void primesInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Prime Number Checking
        int num = 5;
        if (isPrime(num))
            System.out.println("Number is Prime");
        else
            System.out.println("Number isn't Prime");

        // Prime Number in Range
        int Range = 10;
        System.out.print("Prime in given Range is: ");
        primesInRange(Range);

    }
}
