public class _07_CheckingIfPowerOf2 {

    public static boolean check(int n) {
        int x = n & (n - 1);
        return x == 0;
    }

    public static void main(String[] args) {
        int n = 32;
        System.out.println(check(n));
    }
}
