public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        int reverse = reverseNum(x);
        if (x < 0) {
            return false;
        }
        if (reverse == x) {
            return true;
        }
        return false;
    }

    public static int reverseNum(int n) {
        int reverse = 0, remainder;
        while (n != 0) {
            remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }
}
