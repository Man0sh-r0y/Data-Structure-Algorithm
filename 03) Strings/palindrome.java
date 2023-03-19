public class palindrome {

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                // Not a Palindrome
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String str = "racecar";
        if (isPalindrome(str)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String isn't Palindrome");
        }
    }
}
