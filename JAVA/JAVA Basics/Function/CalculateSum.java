public class CalculateSum {

    public static int calculateSum(int a, int b) {// Parameters or Formal Parameters
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        int sum = calculateSum(a, b);// Arguments or actual parameters
        System.out.println("Sum of a & b is " + sum);
    }
}
