import java.util.TreeMap;

public class _05_IntoToTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> lhm = new TreeMap<>();
        // The keys of the hashmap always remains in the sorted order.
        // TreeMap internally implemented in Red Black Tree
        lhm.put("India", 300);
        lhm.put("US", 200);
        lhm.put("Nepal", 100);
        lhm.put("Bhutan", 500);
        lhm.put("Chaina", 400);
        // All the function of hashmap is applicable here (With same time complexity)
        System.out.println(lhm);// {Bhutan=500, Chaina=400, India=300, Nepal=100, US=200}
    }
}
