public class RemoveLetterFromString {

    public static void remove(String newStr, String str, char letter) {
        if (str.isEmpty()) {
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(0);
        if (ch == letter) {
            remove(newStr, str.substring(1), letter);
        } else {
            remove(newStr + ch, str.substring(1), letter);
        }
    }

    public static void main(String[] args) {
        String str = "baccad";
        char letter = 'a';
        remove(new String(), str, letter);
    }
}