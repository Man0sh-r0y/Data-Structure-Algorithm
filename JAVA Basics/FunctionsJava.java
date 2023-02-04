public class FunctionsJava {

    public static void printHelloWorld() {
        System.out.println("Hello World");
        return;
    }

    public static int calculateSum(int a, int b) {// Parameters or Formal Parameters
        int sum = a + b;
        return sum;
    }

    public static int calculateSum(int a, int b, int c) {// Function Overloading
        int sum = a + b + c;
        return sum;
    }

    public static float calculateSum(float a, float b) {// Function Overloading
        float sum = a + b;
        return sum;
    }

    public static int factorial(int num) {
        int f = 1, i = 1;
        while (i <= num) {
            f = f * i;
            i++;
        }
        return f;
    }

    public static int BinomialCoefficient(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);
        int BinomialCoefficient = fact_n / (fact_r * fact_nmr);
        return BinomialCoefficient;
    }

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

    public static int BinaryToDecimal(int BinaryNum) {
        int power = 0;
        int DecimalNumber = 0;
        while (BinaryNum > 0) {
            int lastDigit = BinaryNum % 10;
            DecimalNumber = DecimalNumber + (lastDigit * (int) Math.pow(2, power));
            power++;
            BinaryNum /= 10;
        }
        return DecimalNumber;
    }

    public static int DecimalToBinary(int DecimalNum) {
        int power = 0;
        int BinaryNum = 0;
        while (DecimalNum > 0) {
            int remainder = DecimalNum % 2;
            BinaryNum = BinaryNum + (remainder * (int) Math.pow(10, power));
            power++;
            DecimalNum /= 2;
        }
        return BinaryNum;
    }

    public static int average(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static boolean isEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }

    public static boolean isPalindrome(int number) {
        int myNum = number, lastDigit, reverse = 0;
        for (int i = 0; number != 0; i++) {
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }
        if (myNum == reverse) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumOfDigits(int number) {
        int i = 0, sum = 0, lastDigit;
        while (number != 0) {
            lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        // printing Hello World
        printHelloWorld();// function call

        // sum of a & b
        int a = 10, b = 20, c = 30;
        float A = 2.1F, B = 3.1F;
        int sum1 = calculateSum(a, b);// Arguments or actual parameters
        int sum2 = calculateSum(a, b, c);
        float sum3 = calculateSum(A, B);
        System.out.println("Sum of a & b is " + sum1);
        System.out.println("Sum of a & b & c is " + sum2);
        System.out.println("Sum of a & b is " + sum3);

        // Binomial Coefficient
        int BiCoef = BinomialCoefficient(4, 2);
        System.out.println("Binominal Coefficient is " + BiCoef);

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

        // Binary to Decimal
        int BinaryNumber = 1010;
        System.out.println("Binary to Decimal Conversation is " + BinaryToDecimal(BinaryNumber));

        // Decimal to Binary
        int DecimalNumber = 10;
        System.out.println("Decimal to Binary Conversation is " + DecimalToBinary(DecimalNumber));

    }
}
