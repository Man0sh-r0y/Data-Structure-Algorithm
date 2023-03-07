public class substring {

    public static String SubString(String str, int startIndx, int endIndx) {
        String substr = "";
        for (int i = startIndx; i < endIndx; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    public static void main(String args[]) {
        String str = "Hello World";
        String subString = SubString(str, 0, 5);
        System.out.println("Sub String is " + subString);
    }
}
