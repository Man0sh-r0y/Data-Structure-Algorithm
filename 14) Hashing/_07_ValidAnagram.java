import java.util.HashMap;

public class _07_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        // I'll store the frequency of the charachter of 's' String
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0));
        }
        // Then I'll check in 't' String.
        // I'll iterate over 't' String
        // If charachter in 't' String is contained in hashmap
        // then I'll decrement the frequency.
        // if frequency becomes zero then I'll remove it
        // if Charachter isn't contained then return false,
        // because of not Character matching

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;// Character not matching so false
            }
        }

        return map.isEmpty();
        // if map is empty then true will be returned
        // if map not empty then false will be returned
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t));// O(n) Time Complexity
        // If hasmap worst case is O(n), then this algorithm will take O(n^2)
    }
}
