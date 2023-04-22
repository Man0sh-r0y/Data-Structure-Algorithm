import java.util.HashMap;

public class _01_IntroToHashMap {

    // HashMap has a unique key with a value.
    // Value might not be unique

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 200);
        hm.put("US", 300);

        System.out.println(hm);// {China=200, US=300, India=100}

        // Get Operation - O(1) Time Complexity
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Indonesia"));// null

        // containsKey - O(1) Time Complexity
        System.out.println(hm.containsKey("India"));// true
        System.out.println(hm.containsKey("Indonesia"));// false

        // Remove Operation
        hm.remove("China");
        System.out.println(hm);// {US=300, India=100}

        // size of the HashMap
        System.out.println(hm.size());// 2

        // Is the HashMap Empty
        System.out.println(hm.isEmpty());// false

        // Clear the whole HashMap
        hm.clear();

        System.out.println(hm);// {}
    }
}