import java.util.HashMap;
import java.util.Set;

public class _02_IterationInHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 500);
        hm.put("China", 200);
        hm.put("US", 300);
        hm.put("Japan", 300);
        hm.put("Nepal", 250);
        hm.put("Indonesia", 400);

        Set<String> keys = hm.keySet(); // all keys will be stored
        System.out.println(keys);// [China, Japan, US, Nepal, India, Indonesia]

        for (String it : keys) {// will iterate over keys
            System.out.println("Keys = " + it + ", Value = " + hm.get(it));
        }
    }
}
