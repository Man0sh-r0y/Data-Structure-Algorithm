import java.util.Stack;

public class _05_ReverseString {

    public static String reverse(Stack<Character> s, String str) {
        int indx = 0;
        while (indx < str.length()) {
            s.push(str.charAt(indx));
            indx++;
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char ch = s.pop();
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Manash Roy";
        System.out.println(str);
        str = reverse(new Stack<>(), str);
        System.out.println(str);
    }
}
