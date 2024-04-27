public class _14_PowFunc {

    public static double pow(double x, long n) { // x ^ n
        double ans = 1;
        boolean isNegative = false;

        if (n < 0) {
            n *= -1; // make the n positive
            isNegative = true;
        }

        while(n != 0) {
            if(n % 2 == 0) {
                x = x * x;
                n = n / 2;
            } else {
                ans = ans * x;
                n = n - 1;
            }
        }

        if(isNegative) ans = (double)1.0 / (double)ans;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }
}
