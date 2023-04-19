public class _13_Subsequences {

    public static void subSeq(String newStr, String str) {
        if (str.isEmpty()) {
            System.out.print(newStr + " ");
            return;
        }
        char ch = str.charAt(0);
        subSeq(newStr + ch, str.substring(1));
        subSeq(newStr, str.substring(1));
    }

    public static void main(String[] args) {
        String str = "abc";
        subSeq(new String(""), str);
    }
}