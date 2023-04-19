public class _07_XtothePowerN {

    public static int power(int X, int n) {// X ^ n
        if (n == 0) {
            return 1;
        }
        return X * power(X, n - 1);
    }

    public static int optimizedPower(int X, int n) {// X ^ n
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(X, n / 2);
        halfPower = halfPower * halfPower;
        if (n % 2 != 0) {
            halfPower = X * halfPower;
        }
        return halfPower;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 4));// 3^4
        System.out.println(optimizedPower(3, 4));
    }
}
