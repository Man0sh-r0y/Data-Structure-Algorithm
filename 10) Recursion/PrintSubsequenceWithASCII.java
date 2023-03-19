public class PrintSubsequenceWithASCII {

    public static void subSeqASCII(String newStr, String str) {
        if (str.isEmpty()) {
            System.out.println(newStr);
            return;
        }

        char ch = str.charAt(0);
        subSeqASCII(newStr + ch, str.substring(1)); // taking the element
        subSeqASCII(newStr, str.substring(1)); // not taking the element
        subSeqASCII(newStr + (ch + 0), str.substring(1)); // taking its ascii
    }

    public static void main(String[] args) {
        String str = "ab";
        subSeqASCII(str, str);
    }
}
