public class FunctionOverLoading {

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

    public static void main(String[] args) {
        // sum of a & b
        int a = 10, b = 20, c = 30;
        float A = 2.1F, B = 3.1F;
        int sum1 = calculateSum(a, b);// Arguments or actual parameters
        int sum2 = calculateSum(a, b, c);
        float sum3 = calculateSum(A, B);
        System.out.println("Sum of a & b is " + sum1);
        System.out.println("Sum of a & b & c is " + sum2);
        System.out.println("Sum of a & b is " + sum3);
    }
}
