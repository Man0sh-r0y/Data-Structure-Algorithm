public class _19_phoneKeyPadProblem {

    public static String[] keypad = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void phoneKeyPad(String str, int indx, String newStr) {
        if (indx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(indx);
        String mapping = keypad[currChar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            phoneKeyPad(str, indx + 1, newStr + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "23";
        phoneKeyPad(str, 0, new String());
    }
}
