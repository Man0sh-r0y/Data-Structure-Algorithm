public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        // This string method returns an array after spliting
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        int length = lengthOfLastWord(str);
        System.out.println(length);
    }
}
