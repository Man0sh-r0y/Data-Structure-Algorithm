import java.util.*;

public class _18_SortByFrequency {

    public static String sort(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        // I'll map every character's frequency with the Character itself
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.remove().getKey();
            int frequency = map.get(ch);
            while (frequency != 0) {
                result.append(ch);
                frequency--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "tttttttttttree";
        System.out.println(sort(str));
    }
}
