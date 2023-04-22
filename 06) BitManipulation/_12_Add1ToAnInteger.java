public class _12_Add1ToAnInteger {

    public static int incrementBy1(int n) {
        return -~n;// increment by 1
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(incrementBy1(n));
    }
}
