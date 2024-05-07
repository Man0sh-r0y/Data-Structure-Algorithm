import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _54_LongestSubstringWithotRepeating {

    public static int lengthOfLongestSubstring(String str) {
        int maxLen = 0, l = 0; // left pointer (index)
        Set<Character> set = new HashSet<>(); // to store unique characters

        for(int r=0; r<str.length(); r++) { // right pointer (Index)
            if(set.contains(str.charAt(r))) {
                while(l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0, l = 0; // left pointer (index)

        for(int r=0; r<str.length(); r++) { // right pointer (Index)
            if(map.containsKey(str.charAt(r))) 
                l = Math.max(map.get(str.charAt(r)) + 1, l);
                // inrement the left pointer to the next index of the repeating character
                // Why I did Math.max() ?
                // if the repeated character is at any previous index
                // but the left pointer has moved ahead of that index
                // so their is no point to consider that repeated character
                // taken an example of String = "abba"
            map.put(str.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
