import java.util.Queue;
import java.util.LinkedList;

public class _07_FirstNonRepeatingLetter {

    public static char findFirstNonRepeatingLetter(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26]; // As there are 26 letter from 'a' to 'z'
        // We will track the letters in the String,
        // If any letter is repeating then it's frequency will be higher
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
        }

        while (!q.isEmpty()) {
            if (freq[q.peek() - 'a'] > 1) {
                q.remove();
            } else {
                return q.remove(); // return the 1st non repeating element
            }
        }

        return ' '; // return black space if no found
    }

    public static void main(String[] args) {
        String str = "aabccxb";

        char ch = findFirstNonRepeatingLetter(str);

        if (ch == ' ') {
            System.out.println("No Non-Repeating Letter Found.");
        } else {
            System.out.println(ch);
        }
    }
}
