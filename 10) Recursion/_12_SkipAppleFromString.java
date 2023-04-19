public class _12_SkipAppleFromString {

    public static String skipApple(String str) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.startsWith("apple")) {
            return skipApple(str.substring(5)); // as apple has 5 characters
        } else {
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String str = "bdapplefg";
        str = skipApple(str);
        System.out.println(str); // The string will be 'bdfg'
    }
}
