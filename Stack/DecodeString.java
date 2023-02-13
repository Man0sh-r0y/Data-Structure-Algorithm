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

    public static void decode(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // according to the pattern of the encoding 1st char of the string is a digit
            // and it specifies how many times the text inside parenthesis will be printed
            char ch = str.charAt(i);
            if (ch == ']') {
                // sb.append(s.pop());
            } else {
                s.push(ch);
            }
        }
    }

    public static void main(String[] args) {
        String str = "2[cv]";
        decode(str);
    }
}
