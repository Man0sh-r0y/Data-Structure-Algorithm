import java.util.*;

// We have an encoded string s and the task is to decode it. 
// The pattern in which the strings are encoded is as follows.

// sample Input 1
// : 2[cv]
// Sample Output 1
// : cvcv

// Sample Input 2
// : 3[b2[v]]L
// Sample Output 2
// : bvvbvvbvv

public class DecodeString {

    public static String decode(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder(); // our encoded string
        for (int i = 0; i < str.length(); i++) {
            // according to the pattern of the encoding 1st char of the string is a digit
            // and it specifies how many times the text inside parenthesis will be printed
            char ch = str.charAt(i);
            if (ch == ']') {
                while (!s.isEmpty() && s.peek() != '[') {
                    sb.append(s.pop());
                }
                s.pop(); // popping '['
                int freq = s.peek() - '0'; // frequency of the encoding text how many times it comes
                // above line is to covert from char to int
                StringBuilder temp = new StringBuilder(sb);
                for (int j = 0; j < freq - 1; j++) {
                    sb.append(temp);
                }
                s.pop(); // popping numeric character
            } else {
                s.push(ch);
            }
        }
        sb = sb.reverse();// as inserting in stringbuilder was happening from right to left so we have to
                          // reverse it to read our encoded string
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "2[cv]";
        String str2 = "3[b2[v]]L";
        System.out.println(decode(str));
        System.out.println(decode(str2));
    }
}
