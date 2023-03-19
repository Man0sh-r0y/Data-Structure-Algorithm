public class CheckPalindrom {

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

    public static void main(String[] args) {
        System.out.println(isPalindrome(2442));
    }
}
