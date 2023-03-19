public class BinomialCoefficient {

    public static int factorial(int num) {
        int f = 1, i = 1;
        while (i <= num) {
            f = f * i;
            i++;
        }
        return f;
    }

    public static int binomialCoefficient(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);
        int BinomialCoefficient = fact_n / (fact_r * fact_nmr);
        return BinomialCoefficient;
    }

    public static void main(String[] args) {
        // Binomial Coefficient
        int BiCoef = binomialCoefficient(4, 2);
        System.out.println("Binominal Coefficient is " + BiCoef);
    }
}
